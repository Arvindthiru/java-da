class LRUCache {
    class DBLinkedList{
        int key;
        int value;
        DBLinkedList prev;
        DBLinkedList next;
        
        public DBLinkedList(int key,int value)
        {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
        
    public void insertBeginning(DBLinkedList node)
    {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
    
    public void remove(DBLinkedList node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    
    int size;
    int capacity;
    Map<Integer,DBLinkedList> cache;
    DBLinkedList head,tail;
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer,DBLinkedList>();
        this.capacity = capacity;
        this.size = 0;
        head = new DBLinkedList(0,0);
        tail = new DBLinkedList(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)==true)
        {
            DBLinkedList node = cache.get(key);
            if(node!=head.next)
            {
                remove(node);
                insertBeginning(node); 
            }
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key) == true)
        {
            DBLinkedList node = cache.get(key);
            node.value = value;
            remove(node);
            insertBeginning(node);
            return;
        }
        DBLinkedList node = new DBLinkedList(key,value);
        node.key = key;
        node.value = value;
        if(size<capacity)
        {
            insertBeginning(node);
            cache.put(key,node);
            size++;
        }
        else
        {
            cache.remove(tail.prev.key);
            remove(tail.prev);
            insertBeginning(node);
            cache.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
