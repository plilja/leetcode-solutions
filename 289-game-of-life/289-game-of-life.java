class Solution {
    private static int[] DX = new int[]{ 1, 1, 1,  0, 0, -1, -1, -1};
    private static int[] DY = new int[]{-1, 0, 1, -1, 1, -1,  0,  1};
    
    public void gameOfLife(int[][] board) {
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[0].length; ++x) {
                boolean isLive = board[y][x] % 10 == 1;
                int countNeighbours = 0;
                for (int i = 0; i < 8; ++i) {
                    int dx = DX[i];
                    int dy = DY[i];
                    int xn = x + dx;
                    int yn = y + dy;
                    if (xn >= 0 && xn < board[0].length && yn >= 0 && yn < board.length) {
                        if (board[yn][xn] % 10 == 1) {
                            countNeighbours++;
                        }
                    }
                }
                if (countNeighbours == 3) {
                    board[y][x] += 10;
                }
                if (countNeighbours == 2 && isLive) {
                    board[y][x] += 10;
                }
            }
        }
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[0].length; ++x) {
                board[y][x] /= 10;
            }
        }
    }
}
