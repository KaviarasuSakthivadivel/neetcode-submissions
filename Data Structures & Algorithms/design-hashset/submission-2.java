class MyHashSet {

    private int keyRange;
    private Bucket[] bucketArr;

    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArr = new Bucket[this.keyRange];
        for(int i = 0; i < this.keyRange; i++) {
            bucketArr[i] = new Bucket();
        }
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }
    
    public void add(int key) {
        int hash = this._hash(key);
        bucketArr[hash].insert(key);
    }
    
    public void remove(int key) {
        int hash = this._hash(key);
        bucketArr[hash].delete(key);
    }
    
    public boolean contains(int key) {
        int hash = this._hash(key);
        return bucketArr[hash].exists(key);
    }

    class Bucket {
        private LinkedList<Integer> container;
        public Bucket() {
            container = new LinkedList<>();
        }

        public void insert(Integer key) {
            int index = this.container.indexOf(key);
            if(index == -1) {
                this.container.add(key);
            }
        }

        public void delete(Integer key) {
            this.container.remove(key);
        }

        public boolean exists(Integer key) {
            int index = this.container.indexOf(key);
            return (index != -1);
        }
    }
}
