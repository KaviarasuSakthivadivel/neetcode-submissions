class DynamicArray {

    int[] holder;
    int capacity;
    int length;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.holder = new int[this.capacity];
    }

    public int get(int i) {
        if(i < length) {
            return holder[i];
        }
        return -1;
    }

    public void set(int i, int n) {
        holder[i] = n;
    }

    public void pushback(int n) {
        if(this.length == this.capacity) {
            this.resize();
        }
        this.holder[length++] = n;
    }

    public int popback() {
        if(this.length > 0) {
            this.length--;
        }
        return this.holder[this.length];
    }

    private void resize() {
        this.capacity = this.capacity * 2;

        int arr[] = new int[this.capacity];
        for(int i = 0; i < length; i++) {
            arr[i] = holder[i];
        }
        this.holder = arr;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
