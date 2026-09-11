class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            queue.add(stone);
        }

        while(queue.size() > 1) {
            int p = queue.poll();
            int q = queue.poll();   
            if(p != q) {
                queue.add(p - q);
            }
        }

        return queue.size() == 1 ? queue.peek() : 0;
    }
}
