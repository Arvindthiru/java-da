/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy,tail;
        if(l1 == null)
        {
            return l2;
        }
        else if(l2 == null)
        {
            return l1;
        }
        if(l1.val <= l2.val)
        {
            dummy = l1;
            l1 = l1.next;
            dummy.next = null;
            tail = dummy;
        }
        else
        {
            dummy = l2;
            l2 = l2.next;
            dummy.next = null;
            tail = dummy;
        }
        while(l1 != null && l2 != null)
        {
            //System.out.println("Hell0");
            if(l1.val <= l2.val)
            {
                tail.next = l1;
                l1 = l1.next;
                tail.next.next = null;
                tail = tail.next;
            }
            else
            {
                tail.next = l2;
                l2 = l2.next;
                tail.next.next = null;
                tail = tail.next;
            }
        }
        
        if(l1==null)
        {
            tail.next = l2;
        }
        else if(l2 == null)
        {
            tail.next = l1;
        }
        return dummy;
       
        
    }
}
