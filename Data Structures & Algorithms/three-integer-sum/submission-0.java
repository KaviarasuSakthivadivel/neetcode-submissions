class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(result, nums, -nums[i], i + 1);
        }

        return result;
    }

    private void twoSum(List<List<Integer>> result, int[] nums, int target, int l) {
        int r = nums.length - 1;

        while(l < r) {
            int sum = nums[l] + nums[r];

            if(sum < target) {
                l++;
            } else if(sum > target) {
                r--;
            } else {
                result.add(Arrays.asList(-target, nums[l], nums[r]));
                l++;
                r--;

                // remove duplicates
                while(l < r && nums[l] == nums[l - 1]) {
                    l++;
                }

                while(l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            }
        }
    }
}