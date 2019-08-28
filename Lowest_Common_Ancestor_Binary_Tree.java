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
    TreeNode result = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root,p,q);
        return result;
    }
    
    public boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        boolean left,right,mid=false;
        if(root == null)
        {
            return false;
        }
        left = findLowestCommonAncestor(root.left,p,q);
        right = findLowestCommonAncestor(root.right,p,q);
        if(left == true && right == true)
        {
            result = root;
        }
        if(root.val == p.val || root.val == q.val)
        {
            mid = true;
        }
        if(left == false && right == false)
        {
            if(mid == true)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(mid == true)
            {
                result = root;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
