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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
        {
            return result;
        }
        int count = 0,nextcount=0,flag=0;
        TreeNode temp;
        List<Integer> row;
        Queue<TreeNode> treenodes = new LinkedList<>();
        treenodes.add(root);
        count = 1;
        while(treenodes.isEmpty() == false)
        {
            row = new ArrayList<Integer>();
            while(count > 0)
            {
                temp = treenodes.poll();
                row.add(temp.val);
                if(temp.left!=null)
                {
                    treenodes.add(temp.left);
                    nextcount++;
                }
                if(temp.right!=null)
                {
                    treenodes.add(temp.right);
                    nextcount++;
                }
                count--;
            }
            count = nextcount;
            nextcount = 0;
            if(flag == 0)
            {
                result.add(row);
                flag = 1;   
            }
            else if(flag == 1)
            {
                Collections.reverse(row);
                result.add(row);
                flag = 0;
            }
        }
        return result;
    }
}
