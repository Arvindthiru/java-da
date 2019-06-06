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
    public boolean hasCycle(ListNode head) {
        ListNode first,second;
        if(head == null)
        {
            return false;
        }
        if(head.next == null)
        {
            return false;
        }
        first = head;
        second = head;
        while(second.next.next!=null && first.next!=null)
        {
        
            first = first.next;
            second = second.next.next;
            if(second.next == null)
            {
                break;
            }
            if(first == second)
            {
                return true;
            }    
        }
        return false;
    }
}
