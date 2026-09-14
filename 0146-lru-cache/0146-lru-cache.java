class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key1, int value1) {
            this.key = key1;
            this.val = value1;
        }
    }

    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity_) {
        this.capacity = capacity_;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (map.size() == capacity) {
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertAfterHead(node);
        }
    }

    void deleteNode(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    void insertAfterHead(Node node) {
        Node afterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = afterHead;
        afterHead.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */