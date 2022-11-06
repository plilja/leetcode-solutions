class TicTacToe {
    private static final int[][] DELTAS = new int[][]{
        new int[]{1, 0},
        new int[]{0, 1},
        new int[]{1, 1},
        new int[]{1, -1}
    };
    
    private final int[][] board;
    private final int n;

    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    public int move(int y, int x, int player) {
        board[y][x] = player;
        for (int[] delta : DELTAS) {
            int dx = delta[0];
            int dy = delta[1];
            if (count(y, x, dy, dx) == n) {
                return player;
            }
        }
        return 0;
    }
    
    private int count(int startY, int startX, int dy, int dx) {
        int player = board[startY][startX];
        int result = 0;
        int y = startY + dy;
        int x = startX + dx;
        while (y >= 0 && y < n && x >= 0 && x < n) {
            if (board[y][x] != player) {
                break;
            }
            result++;
            y += dy;
            x += dx;
        }
        y = startY;
        x = startX;
        while (y >= 0 && y < n && x >= 0 && x < n) {
            if (board[y][x] != player) {
                break;
            }
            result++;
            y -= dy;
            x -= dx;
        }
        return result;
    }
}