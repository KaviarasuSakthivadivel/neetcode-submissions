class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rL = board.length;
        int cL = board[0].length;
        for(int r = 0; r < rL; r++) {
            HashSet<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if (board[r][i] == '.') continue;
                if(seen.contains(board[r][i])) {
                    return false;
                }

                seen.add(board[r][i]);
            }
        }

        for(int c = 0; c < cL; c++) {
            HashSet<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if (board[i][c] == '.') continue;
                if(seen.contains(board[i][c])) {
                    return false;
                }

                seen.add(board[i][c]);
            }
        }

        for(int box = 0; box < 9; box++) {
            HashSet<Character> seen = new HashSet<>();

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = (box / 3) * 3 + i;
                    int col = (box % 3) * 3 + j;

                    if (board[row][col] == '.') continue;
                    if(seen.contains(board[row][col])) {
                        return false;
                    }

                    seen.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
