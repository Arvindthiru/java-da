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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur;
        int pop_occur = 0;
        List<Integer> elements = new ArrayList<Integer>();
        Stack<TreeNode> treenodes = new Stack<TreeNode>();
        treenodes.push(root);
        while(treenodes.isEmpty() == false)
        {
            cur = treenodes.peek();
            if(pop_occur == 0)
            {
                if(cur.left!=null)
                {
                    treenodes.push(cur.left);
                    continue;
                }

            }
            elements.add(treenodes.pop().val);
            if(cur.right!=null)
            {
                treenodes.push(cur.right);
                pop_occur = 0;
                continue;
            }
            pop_occur = 1;
            continue;
        }
        return elements.get(k-1);
    }
}
