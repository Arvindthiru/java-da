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
    public boolean isLevelSymmetric(List<String> level)
    {
        int i,j;
        i = 0;
        j = level.size()-1;
        //System.out.println();
        while(i<level.size()/2)
        {
            if(level.get(i).compareTo(level.get(j)) == 0)
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode t,l,r;
        boolean check=false;
        if(root == null)
        {
            return true;
        }
        int qcount = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<String> level = new ArrayList<String>();
        q.add(root);
        while(q.isEmpty()!=true)
        {
            qcount = q.size();
            level = new ArrayList<String>();
            while(qcount>0)
            {
                t = q.poll();
                l = t.left;
                r = t.right;
                if(l!=null)
                {
                    q.add(l);
                    level.add(String.valueOf(l.val));
                }
                else
                {
                    level.add(" ");
                }
                if(r!=null)
                {
                    q.add(r);
                    level.add(String.valueOf(r.val));
                }
                else
                {
                    level.add(" ");
                }
                qcount--;    
            }
            check = isLevelSymmetric(level);
            if(check == false)
            {
                return false;
            }
            
        }
        return true;     
    }
}
