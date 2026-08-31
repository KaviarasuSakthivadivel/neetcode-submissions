static class Node {
    int key, value;
    Node next, prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

static class LinkedList {
    private final Node head;
    private final Node tail;

    public LinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node getLRU() {
        return head.next;
    }
}

class LRUCache {

    private final LinkedList list;
    private final Map<Integer, Node> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        
        list.remove(node);
        list.add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
           list.remove(map.get(key));
        }

        Node node = new Node(key, value);
        list.add(node);
        map.put(key, node);

        if(map.size() > capacity) {
            Node lru = list.getLRU();
            map.remove(lru.key);
            list.remove(lru);
        }
    }
}
