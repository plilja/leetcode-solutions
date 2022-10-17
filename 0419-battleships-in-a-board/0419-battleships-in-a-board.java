class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[y].length; ++x) {
                if (board[y][x] == 'X') {
                    boolean hasLeftX = x > 0 && board[y][x - 1] == 'X';
                    boolean hasTopX = y > 0 && board[y - 1][x] == 'X';
                    if (!hasLeftX && !hasTopX) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
