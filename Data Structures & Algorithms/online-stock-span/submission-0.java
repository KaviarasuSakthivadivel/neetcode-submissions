class StockSpanner {
    // Monotonic stack - stock price, 
    private Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {
        int ans = 1;

        while(!this.stack.isEmpty() && this.stack.peek()[0] <= price) {
            ans += this.stack.pop()[1];
        }

        this.stack.push(new int[]{price, ans});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */