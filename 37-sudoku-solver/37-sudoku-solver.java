class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    
    private boolean solveSudokuHelper(char[][] board) {
        int bestX = -1;
        int bestY = -1;
        Set<Character> possibleAtBest = null;
        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                if (board[y][x] == '.') {
                    Set<Character> possible = new HashSet<>(
                        Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9')
                    );
                    for (int x2 = 0; x2 < 9; ++x2) {
                        possible.remove(board[y][x2]);
                    }
                    for (int y2 = 0; y2 < 9; ++y2) {
                        possible.remove(board[y2][x]);
                    }
                    int squareX = 3 * (x / 3);
                    int squareY = 3 * (y / 3);
                    for (int y2 = squareY; y2 < squareY + 3; ++y2) {
                        for (int x2 = squareX; x2 < squareX + 3; ++x2) {
                            possible.remove(board[y2][x2]);
                        }
                    }
                    if (possibleAtBest == null || possibleAtBest.size() > possible.size()) {
                        bestX = x;
                        bestY = y;
                        possibleAtBest = possible;
                    }
                }
            }
        }
        if (possibleAtBest == null) {
            return true;
        }
        for (char c : possibleAtBest) {
            board[bestY][bestX] = c;
            if (solveSudokuHelper(board)) {
                return true;
            }
        }
        board[bestY][bestX] = '.';
        return false;
    }
}