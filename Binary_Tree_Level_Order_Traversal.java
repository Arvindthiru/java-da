/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode l,r,t;
        int i=0,qcount;
        List<List<Integer>> levels  = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        {
            return levels;
        }
        q.add(root);
        level.add(root.val);
        levels.add(level);
        //level = new ArrayList<Integer>();
        while(q.isEmpty()!=true)
        {
            qcount = q.size();
            level = new ArrayList<Integer>();
            while(qcount >0)
            {
                t = q.poll();
                l = t.left;
                r = t.right;
                if(l!=null)
                {
                    q.add(l);
                    level.add(l.val);
                }
                if(r!=null)
                {
                    q.add(r);
                    level.add(r.val);
                }
                qcount--;
            }
            if(level.size()>0)
            {
                levels.add(level);
            }
            
        }
        return levels;
        
    }
}
    
