class Solution {
    private static int[][] directions = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++) {
            dfs(0, c, heights, pac);
            dfs(ROWS - 1, c, heights, atl);
        }

        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights, pac);
            dfs(r, COLS - 1, heights, atl);
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }   
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] visit) {
        visit[r][c] = true;

        for(int[] d : directions) {
            int dr = d[0] + r;
            int dc = d[1] + c;

            if(dr >= 0 && dr < heights.length && dc >= 0 && dc < heights[0].length && !visit[dr][dc] && heights[dr][dc] >= heights[r][c]) {
                dfs(dr, dc, heights, visit);
            }
        }
    }
}
