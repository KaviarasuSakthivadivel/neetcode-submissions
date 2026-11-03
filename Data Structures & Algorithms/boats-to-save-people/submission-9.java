class Solution {
    public int numRescueBoats(int[] weight, int limit) {
        Arrays.sort(weight);
        int l = 0, r = weight.length - 1, boatCount = 0;

        while(l <= r) {
            boatCount++;

            if(weight[l] + weight[r] <= limit) {
                l++;
            }
            r--;
        }

        return boatCount;
    }
}