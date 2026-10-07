class Solution {

    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    /*
     * i   = which number are we currently deciding about?
     * xor = XOR of the numbers we have already chosen
     */
    private int dfs(int[] nums, int i, int xor) {

        // We have made a decision for every number.
        // Therefore, 'xor' represents one complete subset.
        if (i == nums.length) {
            return xor;
        }

        /*
         * OPTION 1: INCLUDE nums[i]
         *
         * If we include nums[i], update the XOR:
         *
         *       current XOR
         *            ↓
         *     xor ^ nums[i]
         */
        int include = dfs(
            nums,
            i + 1,
            xor ^ nums[i]
        );

        /*
         * OPTION 2: EXCLUDE nums[i]
         *
         * Don't change xor because we didn't include nums[i].
         */
        int exclude = dfs(
            nums,
            i + 1,
            xor
        );

        /*
         * We need the sum of XOR totals
         * from both branches.
         */
        return include + exclude;
    }
}