/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int pos = 0,count = 0 ;
        int a,b;
        ListNode cur = head;
        if(head == null || head.next == null)
        {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        while(cur!=null)
        {
            stack.push(cur.val);
            cur = cur.next;
            count++;
        }
        //System.out.println(stack.get(0));
        while(!stack.empty())
        {
            a = stack.get(pos);
            b = stack.peek();
                
            if(a == b)
            {
                //System.out.println("in");
                stack.pop();
                pos = pos + 1;
            }
            else
            {
                return false;
            }
            if(pos >= count/2)
            {
                break;
            }
            
        }
        return true;
    }
}
