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
        boolean l,r,c = false;
        if(root == null)
        {
            return true;
        }
        l = checkBST(root.left,root.val,min);
        r = checkBST(root.right,max,root.val);        
        if(root.val > min && root.val < max)
        {
            c = true;
        }
        if(l&r&c)
        {
            return true;
        }
        return false;
    }
}

//////////////////////////////////////////////////////////////////////////

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
    public boolean isValidBST(TreeNode root) {
        boolean left,right;
        left = false;
        right = false;
        if(root == null)
        {
            return true;
        }
        left = validateBST(root.left,null,root);
        right = validateBST(root.right,root,null);
        return (left&&right);
    }
    public boolean validateBST(TreeNode Node, TreeNode minNode, TreeNode maxNode)
    {
        if(Node == null)
        {
            return true;
        }
        boolean left,right;
        left = false;
        right = false;
        if(maxNode==null)
        {
            if(Node.val <= minNode.val)
            {
                return false;
            }
            left = validateBST(Node.left,minNode,Node);
            right = validateBST(Node.right,Node,null);
        }
        else if(minNode == null)
        {
            if(Node.val >= maxNode.val)
            {
                return false;
            }
            left = validateBST(Node.left,null,Node);
            right = validateBST(Node.right,Node,maxNode);
        }
        else if(Node.val>minNode.val && Node.val<maxNode.val)
        {
            left = validateBST(Node.left,minNode,Node);
            right = validateBST(Node.right,Node,maxNode);
        }
        return (left && right);
    }
}
