class Solution {
    public int removeDuplicates(int[] nums) {
        
        int l = 1;

        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        for(int r = 1; r < nums.length; r++) {
            if(nums[r] != nums[r - 1]) {
                nums[l++] = nums[r];
            }
        }

        return l;
    }
}