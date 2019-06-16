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
    
    public boolean isValidBST(TreeNode root) 
    {
        boolean check;
        check = checkBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
        if(check)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    public boolean checkBST(TreeNode root,long max,long min)
    {
        //System.out.println(max);
        boolean l,r,c = false;
        if(root == null)
        {
            return true;
        }
        l = checkBST(root.left,root.val,min);
        r = checkBST(root.right,max,root.val);        
        if(root.val > min && root.val < max)
        {
            //System.out.println(root.val);
            c = true;
        }
        if(l&r&c)
        {
            return true;
        }
        return false;
    }
}
