class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currentSum += nums[windowEnd];

            // Shrink it
            while(currentSum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                currentSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}