class LRUCache {

    class Node {

        Node next;
        Node previous;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> lruMap;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        lruMap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
        this.capacity = capacity;

    }
    
    public int get(int key) {
        if(lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            removeNode(node);
            insertFront(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            removeNode(node);
        }
        Node node = new Node(key, value);
        insertFront(node);
        lruMap.put(key, node);
        if(lruMap.size() > capacity) {
            Node lru = tail.previous;
            removeNode(lru);
            lruMap.remove(lru.key);
        }
    }

    public void removeNode(Node node) {
        node.next.previous = node.previous;
        node.previous.next = node.next;
    }

    public void insertFront(Node node) {
        node.next = head.next;
        node.next.previous = node;
        head.next = node;
        node.previous = head;
    }
}
