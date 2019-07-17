/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null)
        {
            return null;
        }
        int countA=1,countB=1,diff;
        ListNode NodeA,NodeB;
        NodeA = headA;
        NodeB = headB;
        while(NodeA!=null)
        {
            countA++;
            NodeA = NodeA.next;
        }
        while(NodeB!=null)
        {
            countB++;
            NodeB = NodeB.next;
        }
        NodeA = headA;
        NodeB = headB;
        if(countA>countB)
        {
            diff = countA-countB;
            while(diff>0)
            {
                NodeA = NodeA.next;
                diff--;
            }
        }
        else if(countB>countA)
        {
            diff = countB-countA;
            while(diff>0)
            {
                NodeB = NodeB.next;
                diff--;
            }
        }
        while(NodeA!=null && NodeB!=null)
        {
            if(NodeA == NodeB)
            {
                return NodeA;
            }
            NodeA = NodeA.next;
            NodeB = NodeB.next;
        }
        return null;
    }
}
