class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[] result = new int[nums.length - k + 1];

        int idx = 0;

        for(int end = 0; end < nums.length; end++) {
            heap.offer(new int[]{nums[end], end});

            if(end >= k - 1) {
                while(heap.peek()[1] <= end - k) {
                    heap.poll();
                }

                result[idx++] = heap.peek()[0];
            }
        }

        return result;
    }
}
