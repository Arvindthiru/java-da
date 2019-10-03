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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        if(root.left==null && root.right == null)
        {
            return 0;
        }
        int left = getPath(root.left);
        int right = getPath(root.right);
        ans = Math.max(ans,left+right);
        return ans;
    }
    public int getPath(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = getPath(root.left);
        int right = getPath(root.right);
        ans = Math.max(ans,left+right);
        return Math.max(left+1,right+1);
    }
}
