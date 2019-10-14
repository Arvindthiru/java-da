/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i=1;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode Node = head;
        ListNode begin,end,temp;
        begin = dummyhead;
        while(Node!=null)
        {
            if(i%k==0)
            {
                temp = begin;
                end = Node.next;
                begin = reverse(begin,end);
                temp.next = Node;
                begin.next = end;
                Node = begin.next;
            }
            else
            {
                Node = Node.next;
            }
            i++;
        }
        return dummyhead.next;
    }
    public ListNode reverse(ListNode begin, ListNode end)
    {
        ListNode t = begin.next;
        ListNode prev = begin.next;
        ListNode cur = prev.next;
        ListNode after;
        while(cur!=end)
        {
            after = cur.next;
            cur.next = prev;
            prev = cur;
            cur = after;
        }
        return t;
    }
}
