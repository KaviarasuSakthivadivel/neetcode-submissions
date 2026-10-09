record RowSegment(int row, int col, int len) {}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int N = grid.length;
        if (grid[0][0] != 0 || grid[N - 1][N - 1] != 0) {
            return -1;
        }

        Queue<RowSegment> queue = new LinkedList<>();
        int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, -1}, {-1, 1}, {1, 1}, {-1, -1}
        };
        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;
        queue.offer(new RowSegment(0, 0, 1));

        while(!queue.isEmpty()) {
            RowSegment rs = queue.poll();
            int r = rs.row(), c = rs.col(), len = rs.len();

            if(r == N - 1 && c == N - 1) {
                return len;
            }

            for(int[] d : directions) {
                int nr = d[0] + r;
                int nc = d[1] + c;

                if(nr >= 0 && nc >= 0 && nr < N && nc < N && grid[nr][nc] == 0 && !visit[nr][nc]) {
                    queue.offer(new RowSegment(nr, nc, len + 1));
                    visit[nr][nc] = true;
                }
            }
        }

        return -1;
    }
}