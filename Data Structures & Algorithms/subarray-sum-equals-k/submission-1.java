class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int res = 0, currSum = 0;

        for(int num : nums) {

            currSum += num;
            int diff = currSum - k;

            res += prefixSum.getOrDefault(diff, 0);

            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }
}