class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rowL = matrix.length;
        int colL = matrix[0].length;
        prefix = new int[rowL][colL + 1];

        for(int r = 0; r < rowL; r++) {
            for(int c = 0; c < colL; c++) {
                prefix[r][c + 1] = prefix[r][c] + matrix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int row = row1; row <= row2; row++) {
            sum += (prefix[row][col2 + 1] - prefix[row][col1]);
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */