class Solution {
    public int removeElement(int[] nums, int val) {
        int nonElementIndex = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[nonElementIndex] = nums[i];
                nonElementIndex++;
            }
        }

        return nonElementIndex;
    }
}