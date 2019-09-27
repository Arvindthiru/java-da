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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
        {
            return false;
        }
        boolean result1=false,result2=false;
        if(s.val == t.val)
        {
            boolean result = isSame(s,t);
            if(result == true)
            {
                return result;
            }
            else
            {
                result1 = isSubtree(s.left,t);
                result2 = isSubtree(s.right,t);
            }
        }
        else
        {
            result1 = isSubtree(s.left,t);
            result2 = isSubtree(s.right,t);
        }
        return (result1||result2);        
    }
    public boolean isSame(TreeNode a, TreeNode b){
        if((a == null && b!=null) || (a!=null && b == null))
        {
            return false;
        }
        if(a==null && b==null)
        {
            return true;
        }
        boolean left=false,right=false;
        if(a.val == b.val)
        {
            left = isSame(a.left,b.left);
            right = isSame(a.right,b.right);
        }
        return (left&&right);
    }
}
