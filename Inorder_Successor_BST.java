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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null)
        {
           return findMin(p.right);
        }
        TreeNode node,successor;
        node = root;
        successor = null;
        while(node!=p)
        {
            if(node.val > p.val)
            {
                successor = node;
                node = node.left;
            }
            if(node.val < p.val)
            {
                node = node.right;
            }
        }
        if(successor!=null)
        {
            return successor;
        }
        return successor;
    }
    
    public TreeNode findMin(TreeNode root)
    {
        while(root.left!=null)
        {
            root = root.left;
        }
        return root;
    }
}
