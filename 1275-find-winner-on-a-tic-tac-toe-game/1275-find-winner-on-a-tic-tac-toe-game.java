class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][];
        for (int y = 0; y < 3; ++y) {
            grid[y] = new int[3];
        }
        int player = 1;
        for (int[] move : moves) {
            int y = move[0];
            int x = move[1];
            grid[y][x] = player;
            player = player == 1 ? 2 : 1;
        }
        if (playerWins(grid, 1)) {
            return "A";
        }
        if (playerWins(grid, 2)) {
            return "B";
        }
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 3; ++x) {
                if (grid[y][x] == 0) {
                    return "Pending";
                }
            }
        }
        return "Draw";
    }
    
    private boolean playerWins(int[][] grid, int player) {
        // check horizontal 3 in row
        for (int y = 0; y < 3; ++y) {
            if (grid[y][0] == player && grid[y][1] == player && grid[y][2] == player) {
                return true;
            }
        }
        // check vertical 3 in row
        for (int x = 0; x < 3; ++x) {
            if (grid[0][x] == player && grid[1][x] == player && grid[2][x] == player) {
                return true;
            }
        }
        // check left right diag
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        // check right left diag
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }
        
        return false;
    }
}
