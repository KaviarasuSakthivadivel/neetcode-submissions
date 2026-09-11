class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] point : points) {
            int x = point[0], y = point[1];
            queue.offer(new int[]{(x * x + y * y), x, y});
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] el = queue.poll();
            result[i] = new int[]{el[1], el[2]};
        }

        return result;
    }
}
