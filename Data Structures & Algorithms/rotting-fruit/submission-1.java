static record Cell(int row, int col) {}

class Solution {
    private final int[][] directions = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();
        int ROWS = grid.length, COLS = grid[0].length;


        int fresh = 0, time = 0;

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == 1) { // Fresh cell
                    fresh++;
                } else if(grid[i][j] == 2) { // Rotten cell
                    queue.add(new Cell(i, j));
                }
            }
        }

        while(fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();

            for(int i = 0; i < length; i++) {
                Cell cell = queue.poll();

                for(int[] d : directions) {
                    int dr = d[0] + cell.row(), dc = d[1] + cell.col();

                    if(dr >= 0 && dr < ROWS && dc >= 0 && dc < COLS && grid[dr][dc] == 1) {
                        fresh--;
                        grid[dr][dc] = 2;
                        queue.add(new Cell(dr, dc));
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
