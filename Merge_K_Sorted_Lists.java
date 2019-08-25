/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int i,flag=0;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2)
            {
                return (n1.val-n2.val);
            }
        });
        ListNode head=null,node=null,temp;
        for(i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                temp = lists[i];
                queue.add(temp);
            }
        }
        while(queue.isEmpty() == false)
        {
            if(flag == 0)
            {
                temp = queue.poll();
                head = temp;
                temp = temp.next;
                if(temp!=null)
                {
                    queue.add(temp);
                }
                head.next = null;
                node = head;
                flag = 1;
                if(queue.isEmpty() == true)
                {
                    break;
                }
            }
            temp = queue.poll();
            node.next = temp;
            temp = temp.next;
            node = node.next;
            node.next = null;
            if(temp!=null)
            {
                queue.add(temp);
            }
        }
        return head;
    }
}
