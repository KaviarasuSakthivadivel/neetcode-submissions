class Solution {
    private static int[][] directions = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == 1) {
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }

        return area;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        int count = 1;
        grid[r][c] = 0;

        for(int[] d : directions) {
            int dr = d[0] + r, dc = d[1] + c;
            count += dfs(grid, dr, dc);
        }

        return count;
    }
}
