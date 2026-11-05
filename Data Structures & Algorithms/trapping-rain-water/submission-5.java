class Solution {
    public int trap(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int left = 0, right = heights.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                leftMax = Math.max(leftMax, heights[left]);
                water += leftMax - heights[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                water += rightMax - heights[right];
                right--;
            }
        }
        return water;
    }
}
