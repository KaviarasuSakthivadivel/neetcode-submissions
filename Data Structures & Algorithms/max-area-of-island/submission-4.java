static record Cell(int row, int col) {}
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

    private int bfs(int[][] grid, int r, int c) {
        Queue<Cell> queue = new LinkedList<>();
        int count = 1;
        queue.add(new Cell(r, c));
        grid[r][c] = 0;

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();

            for(int[] d : directions) {
                int dr = cell.row() + d[0], dc = cell.col() + d[1];
                if(dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length && grid[dr][dc] == 1) {
                    grid[dr][dc] = 0;
                    count++;
                    queue.add(new Cell(dr, dc));
                }
            }
        }

        return count;
    }
}
