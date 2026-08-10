class Solution {
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        // Splitting at mid, always mean one side is sorted.
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            // left side is sorted?
            if(arr[left] <= arr[mid]) {
                if(arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
