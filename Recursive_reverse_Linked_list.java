/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode node) {
        
        ListNode sep_list,revList;
        if(node == null)
        {
            return null;
        }
        if(node.next == null)
        {
            return node;
        }
        sep_list = node.next;
        node.next = null;
        revList = reverseList(sep_list);
        sep_list.next = node;
        
        return revList;
        
    }
}
