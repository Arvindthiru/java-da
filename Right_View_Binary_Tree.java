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
    int depth=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        result.add(root.val);
        traverseTree(result,root.right,1);
        traverseTree(result,root.left,1);
        return result;
    }
    public void traverseTree(List<Integer> result,TreeNode root,int currentDepth)
    {
        if(root == null)
        {
            return;
        }
        if(currentDepth>depth)
        {
            result.add(root.val);
            depth+=1;
        }
        currentDepth+=1;
        traverseTree(result,root.right,currentDepth);
        traverseTree(result,root.left,currentDepth);
    }
}
