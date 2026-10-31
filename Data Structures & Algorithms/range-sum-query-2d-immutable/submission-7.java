class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rowL = matrix.length;
        int colL = matrix[0].length;
        prefix = new int[rowL + 1][colL + 1];

        for(int r = 0; r < rowL; r++) {
            for(int c = 0; c < colL; c++) {
                int above = prefix[r][c + 1];
                int left = prefix[r + 1][c];
                prefix[r + 1][c + 1] = matrix[r][c] + above + left - prefix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */