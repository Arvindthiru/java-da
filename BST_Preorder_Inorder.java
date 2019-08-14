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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = constructTree(preorder,inorder,0,0,inorder.length-1);
        return root;
    }
    
    public TreeNode constructTree(int[] preorder,int[] inorder, int preIndex,int inStart, int inEnd)
    {
        if(inStart>inEnd)
        {
            return null;
        }
        int inIndex,lSubTreeLen;
        TreeNode Node = new TreeNode(preorder[preIndex]);
        inIndex = search(inorder,inStart,inEnd,preorder[preIndex]);
        lSubTreeLen = inIndex - inStart;
        Node.left = constructTree(preorder,inorder,preIndex+1,inStart,inIndex-1);
        Node.right = constructTree(preorder,inorder,preIndex+lSubTreeLen+1,inIndex+1,inEnd);
        return Node;
    }
    
    public int search(int[] inorder, int inStart, int inEnd, int target)
    {
        int i,result=-1;
        for(i=inStart;i<=inEnd;i++)
        {
            if(inorder[i] == target)
            {
                result = i;
            }
        }
        return result;
    }
}
