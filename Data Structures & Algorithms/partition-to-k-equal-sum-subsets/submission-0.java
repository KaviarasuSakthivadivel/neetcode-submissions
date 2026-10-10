class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        // early pruning
        if(sum % k != 0) {
            return false;
        }

        int target = sum / k;
        Arrays.sort(nums);

        int n = nums.length;
        for(int i = 0; i < n / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = tmp;
        }

        boolean[] used = new boolean[n];
        return backtrack(0, target, 0, nums, used, k);
    }

    private boolean backtrack(int start, int target, int currentSum, int[] nums, boolean[] used, int k) {
        if(k == 0) {
            return true;
        }

        if(currentSum == target) {
            return backtrack(0, target, 0, nums, used, k - 1);
        }

        for(int i = start; i < nums.length; i++) {
            if(used[i] || currentSum + nums[i] > target) {
                continue;
            }

            used[i] = true;
            if(backtrack(i + 1, target, nums[i] + currentSum, nums, used, k)) {
                return true;
            }
            used[i] = false;

            if(currentSum == 0) {
                return false;
            }
        }

        return false;
    }
}