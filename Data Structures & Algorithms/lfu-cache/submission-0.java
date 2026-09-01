static class Node {
    int key, value, count;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }
}

static class DoublyLinkedList {
    Node head, tail;
    int size;

    public DoublyLinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // always add it at the tail
    public void add(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node pollLFU() {
        if(size > 0) {
            Node lfu = head.next;
            remove(lfu);

            return lfu;
        }
        return null;
    }
}

class LFUCache {

    private HashMap<Integer, Node> nodeMap;
    private HashMap<Integer, DoublyLinkedList> freqMap;
    private int leastFreqCount;
    private int capacity;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        leastFreqCount = 1;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(capacity == 0 || !nodeMap.containsKey(key)) {
            return -1;
        }
        
        Node node = nodeMap.get(key);
        update(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(nodeMap.containsKey(key)) {
            Node nodeToBeUpdated = nodeMap.get(key);
            nodeToBeUpdated.value = value;

            update(nodeToBeUpdated);
        } else {
            // If capacity exceed, Poll the LFU and remove from the nodeMap
            if(this.capacity == nodeMap.size()) {
                DoublyLinkedList lastFreqList = freqMap.get(leastFreqCount);
                nodeMap.remove(lastFreqList.pollLFU().key);
            }

            Node node = new Node(key, value);
            leastFreqCount = 1;

            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).add(node);
            nodeMap.put(key, node);
        }
    }

    private void update(Node node) {
        DoublyLinkedList oldDLL = freqMap.get(node.count);
        oldDLL.remove(node);

        if(node.count == leastFreqCount && oldDLL.size == 0) {
            leastFreqCount++;
        }

        node.count++;
        DoublyLinkedList newDLL = freqMap.getOrDefault(node.count, new DoublyLinkedList());
        newDLL.add(node);

        freqMap.put(node.count, newDLL);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */