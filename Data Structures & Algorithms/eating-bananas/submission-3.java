class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int minK = right;

        while(left <= right) {
            int k = left + (right - left) / 2;
            if (k == 0) k = 1;

            long hours = 0;
            for(int banana : piles) {
                hours += (banana + k - 1L) / k;
            }

            if(hours <= h) {
                minK = Math.min(minK, k);
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return minK;
    }
}
