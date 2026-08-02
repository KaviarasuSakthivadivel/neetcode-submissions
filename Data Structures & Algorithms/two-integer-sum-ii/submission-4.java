class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int sum = nums[l] + nums[r];

            if(sum < target) {
                l++;
            } else if(sum > target) {
                r--;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }

        return new int[]{};
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement)  + 1, i + 1};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
