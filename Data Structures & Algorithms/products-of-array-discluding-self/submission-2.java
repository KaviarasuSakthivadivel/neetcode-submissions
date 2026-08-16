class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] suffix = new int[l];
        int[] prefix = new int[l];
        int[] result = new int[l];

        prefix[0] = 1;
        for(int i = 1; i < l; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[l - 1] = 1;
        for(int i = l - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < l; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
