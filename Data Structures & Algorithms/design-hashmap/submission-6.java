class ListNode {
    int key, value;
    ListNode next;

    public ListNode() {
        this(-1, -1, null);
    }

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class MyHashMap {
    private ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for(int i = 0; i < 1000; i++) {
            map[i] = new ListNode();
        }
    }
    
    private int _hash(int key) {
        return key % this.map.length;
    }

    public void put(int key, int value) {
        ListNode current = map[_hash(key)];

        while(current.next != null) {
            if(current.next.key == key) {
                current.next.value = value;
                return;
            }
            current = current.next;
        }

        current.next = new ListNode(key, value, null);
    }
    
    public int get(int key) {
        ListNode current = map[_hash(key)].next;
        while(current != null) {
            if(current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        ListNode current = map[_hash(key)];

        while(current.next != null) {
            if(current.next.key == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */