class LRUCache {

    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    int capacity1;

    HashMap<Integer, ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity1 = capacity;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        deleteBeforeTail(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            deleteBeforeTail(node);
            insertAfterHead(node);
        } else {
            if (capacity1 == map.size()) {
                ListNode node = tail.prev;
                map.remove(node.key);
                deleteBeforeTail(node);
            }

            ListNode node = new ListNode(key, value);
            map.put(key, node);
            insertAfterHead(node);
        }


    }

    void insertAfterHead (ListNode node) {
        ListNode AfterHead = head.next;
        head.next = node;
        node.next = AfterHead;
        node.prev = head;
        AfterHead.prev = node;
    }

    void deleteBeforeTail (ListNode node) {
        ListNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */