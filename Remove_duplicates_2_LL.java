/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        {
            return head;
        }
        boolean dupFlag = false;
        ListNode dummyHead,dummyNode;
        dummyHead = null;
        dummyNode = null;
        ListNode node = head;
        while(node.next!=null)
        {
            if(node.next.val == node.val)
            {
                dupFlag = true;
                node = node.next;
                continue;
            }
            if(dupFlag == true)
            {
                dupFlag = false;
                node = node.next;
                continue;
            }
            if(dummyHead == null)
            {
                dummyHead = node;
                dummyNode = dummyHead;
            }
            else
            {
                dummyNode.next = node;
                dummyNode = dummyNode.next;
            }
            node = node.next;
        }
        if(dummyNode!=null)
        {
            dummyNode.next = null;
        } 
        if(dupFlag == false)
        {
            if(dummyHead == null)
            {
                dummyHead = node;
            }
            else
            {
                dummyNode.next = node;
            }
        }
        return dummyHead;
    }
}
