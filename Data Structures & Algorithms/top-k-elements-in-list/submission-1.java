class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        if(nums.length == k) {
            return nums;
        }
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (n1, n2) -> countMap.get(n1) - countMap.get(n2));
        for(int key : countMap.keySet()) {
            pq.add(key);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}
