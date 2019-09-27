/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return head;
        }
        Map<Node,Node> OldtoNew = new HashMap<>();
        Node cur = head;
        int headFlag = 0;
        Node newHead = null;
        while(cur!=null)
        {
            if(headFlag == 0)
            {
                newHead = new Node(cur.val,null,null);
                OldtoNew.put(cur,newHead);
                headFlag++;
                cur = cur.next;
                continue;
            }
            OldtoNew.put(cur,new Node(cur.val,null,null));
            cur = cur.next;
        }
        cur = head;
        //Node newNode
        while(cur.next!=null)
        {
            (OldtoNew.get(cur)).next = OldtoNew.get(cur.next);
            (OldtoNew.get(cur)).random = OldtoNew.get(cur.random);
            cur = cur.next;
        }
        (OldtoNew.get(cur)).next = null;
        if(cur.random == null)
        {
            (OldtoNew.get(cur)).random = null;
        }
        else
        {
            (OldtoNew.get(cur)).random = OldtoNew.get(cur.random);
        }
        return newHead;
        
    }
}
