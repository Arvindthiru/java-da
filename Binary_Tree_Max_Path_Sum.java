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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int max;
        max = traverseTree(root);
        return res;
    }
    public int traverseTree(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int l,r,max;
        l = Math.max(traverseTree(root.left),0);
        r = Math.max(traverseTree(root.right),0);
        res = Math.max(res,(root.val+l+r));
        max = Math.max((root.val+l),(root.val+r));
        return max;
    }
}
