class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int prevSum = target - nums[i];
            if(map.containsKey(prevSum)) {
                return new int[]{map.get(prevSum), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
