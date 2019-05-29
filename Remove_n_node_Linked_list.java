/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur,nnode;
        int count = 2;
        nnode = head.next;
        cur = head;
        if(head.next==null && n == 0)
        {
            return head;
        }
        else if( head.next == null && n == 1)
        {
            head = null;
            return head;
        }
        while(count < n)
        {
            if(nnode.next!=null)
            {
                nnode = nnode.next;
                count++;
            }
        }
        while(nnode.next!=null)
        {
            cur = cur.next;
            nnode = nnode.next;
        }
        if(n == 1)
        {
            cur.next = null;
            return head;
        }
 
        cur.val = cur.next.val;
        if(cur.next.next == null)
        {
            cur.next = null;
        }
        else
        {
            cur.next = cur.next.next;
        }
        return head;
    }
}
