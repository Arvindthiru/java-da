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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root;
        if(nums.length == 0)
        {
            return null;
        }
        int left = 0;
        root = formBST(nums,left,nums.length-1);
        return root;
    }
    
    public TreeNode formBST(int[] nums,int left,int right)
    {
        int mid;
        if(left == right)
        {
            TreeNode Node = new TreeNode(nums[left]);
            return Node;
        }
        if(left > right || right < left)
        {
            return null;
        }
        mid = (int)Math.ceil((left+right)*(float)0.5);
        TreeNode Node = new TreeNode(nums[mid]);
        if(mid>= left && mid<=right)
        {
            Node.left = formBST(nums,left,mid-1);
            Node.right = formBST(nums,mid+1,right);
        }
        return Node;
        
    }
        
}
