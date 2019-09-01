/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
        {
            return null;
        }
        ListNode meetPoint;
        meetPoint = checkCycle(head);
        if(meetPoint == null)
        {
            return null;
        }
        while(true)
        {
            if(head == meetPoint)
            {
                break;
            }
            head = head.next;
            meetPoint = meetPoint.next;
        }
        return head;
    }
    public ListNode checkCycle(ListNode head)
    {
        ListNode slow,fast;
        slow = head;
        fast = head;
        if(slow.next == null)
        {
            return null;
        }
        while(fast!=null)
        {
            slow = slow.next;
            if(fast.next == null)
            {
                break;
            }
            fast = fast.next.next;
            if(slow == fast)
            {
                return slow;
            }
        }
        return null;
    }
}
