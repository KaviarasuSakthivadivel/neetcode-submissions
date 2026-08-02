class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        for(int i = 0; i < N - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }    

            for(int j = i + 1; j < N - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                searchPair(result, nums, (long) target, i, j, j + 1);
            }
        }

        return result;
    }

    private void searchPair(List<List<Integer>> result, int[] nums, long target, int i, int j, int l) {
        int r = nums.length - 1;

        while(l < r) {
            long sum = (long)nums[l] + nums[r] + nums[i] + nums[j];

            if(sum < target) {
                l++;
            } else if(sum > target) {
                r--;
            } else {
                result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
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