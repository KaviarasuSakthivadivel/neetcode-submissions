class MyCircularQueue {
    int arr[];
    int size, front, rear, k;

    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.arr.length;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? - 1 : arr[this.front];
    }
    
    public int Rear() {
        return isEmpty() ?  -1 : arr[this.rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == this.arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */