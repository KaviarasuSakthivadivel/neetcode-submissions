class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // List<Integer> weightList = Arrays.stream(weights).boxed().collect(Collectors.toList());

        // int low = Collections.max(weightList);
        // int high = weightList.stream().mapToInt(i -> i).sum();

        int low = 0, high = 0;

        for(int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            // reduce the search space by left half
            if(isShippingPossibleWithinMDays(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    
    private boolean isShippingPossibleWithinMDays(int[] nums, int sum, int m) {
        int splits = 0, currentSum = 0;

        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if(currentSum > sum) {
                currentSum = nums[i];
                splits++;

                if(splits > m - 1) {
                    return false;
                }
            }
        }

        return true;
    }
}