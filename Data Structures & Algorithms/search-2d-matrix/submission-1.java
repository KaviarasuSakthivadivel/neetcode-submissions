class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int left = 0, right = ROWS * COLS - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / COLS;
            int col = mid % COLS;

            if(target > matrix[row][col]) {
                left = mid + 1;
            } else if (target < matrix[row][col]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }       
}
