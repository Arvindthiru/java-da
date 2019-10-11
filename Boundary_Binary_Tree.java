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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        result.add(root.val);
        getLeft(root.left,result);
        getLeaves(root.left,result);
        getLeaves(root.right,result);
        getRight(root.right,result);
        return result;
    }
    public void getLeft(TreeNode Node,List<Integer> result)
    {
        if(Node == null)
        {
            return;
        }
        if(Node.left == null && Node.right == null)
        {
            return;
        }
        result.add(Node.val);
        if(Node.left!=null)
        {
            getLeft(Node.left,result);
        }
        else if(Node.right!=null)
        {
            getLeft(Node.right,result);
        } 
    }
    public void getLeaves(TreeNode Node,List<Integer> result)
    {
        if(Node == null)
        {
            return;
        }
        if(Node.left == null && Node.right == null)
        {
            result.add(Node.val);
            return;
        }
        getLeaves(Node.left,result);
        getLeaves(Node.right,result);
    }
    public void getRight(TreeNode Node,List<Integer> result)
    {
        if(Node==null)
        {
            return;
        }
        if(Node.left==null && Node.right==null)
        {
            return;
        }
        if(Node.right!=null)
        {
            getRight(Node.right,result);
        }
        else if(Node.left!=null)
        {
            getRight(Node.left,result);
        }
        result.add(Node.val);
    }
}
