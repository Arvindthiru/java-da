/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode cur,temp;;
        ListNode oddhead,evenhead;
        int flag=0;
        if(head == null || head.next==null || head.next.next == null)
        {
            return head;
        }
        oddhead = head;
        evenhead = head.next;
        cur = head;
        while(cur.next.next!=null)
        {
            if(flag == 0)
            {
                flag = 1;
            }
            else
            {
                flag = 0;
            }
            temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        if(flag == 0)
        {
            cur.next = evenhead;
        }
        else if(flag == 1)
        {
            cur.next.next = evenhead;
            cur.next = null;
        }
        return head;
        //int start;

    }
}
