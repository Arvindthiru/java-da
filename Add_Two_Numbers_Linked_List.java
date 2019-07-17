/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur=null,prev=null,head=null;
        int x,d,carry=0,count = 0;
        while(l1!=null && l2!=null)
        {
            x = l1.val+l2.val+carry;
            if(x<10)
            {
                cur = new ListNode(x);
                carry = 0;
            }
            else
            {
                d = x%10;
                cur = new ListNode(d);
                carry = 1;
            }
            if(count == 0)
            {
                head = cur;
            }
            if(count > 0)
            {
                prev.next = cur;
            }
            prev = cur;
            count++;
            l1 = l1.next;
            l2 = l2.next;
        }
        //cur = head;
        if(l1 == null && l2 !=null)
        {
            while(l2!=null)
            {
                if(carry == 1)
                {
                    x = l2.val+1;
                    if(x == 10)
                    {
                        cur = new ListNode(0);
                        carry = 1;
                    }
                    else
                    {
                        cur = new ListNode(x);
                        carry = 0;
                    }
                    
                }
                else
                {
                    cur = new ListNode(l2.val);
                }
                prev.next = cur;
                prev = cur;
                l2 = l2.next;
            }
        }
        else if(l2 == null && l1!=null)
        {
            while(l1!=null)
            {
                if(carry == 1)
                {
                    x = l1.val+1;
                    if(x == 10)
                    {
                        cur = new ListNode(0);
                        carry = 1;
                    }
                    else
                    {
                        cur = new ListNode(x);
                        carry = 0;
                    }
                    
                }
                else
                {
                    cur = new ListNode(l1.val);
                }
                prev.next = cur;
                prev = cur;
                l1 = l1.next;
            }
        }
        if(l1 == null && l2 ==null && carry == 1)
        {
            cur = new ListNode(carry);
            prev.next = cur;
        }
        return head;
    }
}
