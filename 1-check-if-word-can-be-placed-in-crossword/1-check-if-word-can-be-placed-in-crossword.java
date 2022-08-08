class Solution {
    private boolean fitsAt(char[][] board, String word, int startX, int startY, int dx, int dy) {
        int prevX = startX - dx;
        int prevY = startY - dy;
        if (prevX >= 0 && prevX < board[0].length && prevX != startX) {
            if (board[startY][prevX] != '#') {
                return false;
            }
        }
        if (prevY >= 0 && prevY < board.length && prevY != startY) {
            if (board[prevY][startX] != '#') {
                return false;
            }
        }
        int x = startX;
        int y = startY;
        int count = 0;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (board[y][x] == '#') {
                return false;
            }
            if (board[y][x] != ' ' && board[y][x] != c) {
                return false;
            }
            count++;
            x += dx;
            y += dy;
            if (y < 0 || y >= board.length) {
                break;
            }
            if (x < 0 || x >= board[0].length) {
                break;
            }
        }
        if (x >= 0 && x < board[0].length && x != startX) {
            if (board[startY][x] != '#') {
                return false;
            }
        }
        if (y >= 0 && y < board.length && y != startY) {
            if (board[y][startX] != '#') {
                return false;
            }
        }
        if (count == word.length()) {
            int a = 1;
        }
        return count == word.length();
    }
    
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[y].length; ++x) {
                if (fitsAt(board, word, x, y, 1, 0)) {
                    return true;
                }
                if (fitsAt(board, word, x, y, -1, 0)) {
                    return true;
                }
                if (fitsAt(board, word, x, y, 0, 1)) {
                    return true;
                }
                if (fitsAt(board, word, x, y, 0, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
