class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(dfs(board, r, c, word, 0, visited)) {
                    return true;
                }
            }    
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int i, boolean[][] visited) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if(i == word.length()) {
            return true;
        }

        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(i) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        boolean match = dfs(board, r + 1, c, word, i + 1, visited) || 
                        dfs(board, r, c + 1, word, i + 1, visited) ||
                        dfs(board, r - 1, c, word, i + 1, visited) ||
                        dfs(board, r, c - 1, word, i + 1, visited);
        visited[r][c] = false;

        return match;
    }
}
