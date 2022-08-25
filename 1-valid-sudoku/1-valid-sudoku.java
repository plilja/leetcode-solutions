class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int y = 0; y < 9; ++y) {
            List<Character> nums = new ArrayList<>();
            for (int x = 0; x < 9; ++x) {
                if (isFilledIn(board[y][x])) {
                    nums.add(board[y][x]);
                }
            }
            if (nums.size() != new HashSet<>(nums).size()) {
                return false;
            }
        }
        for (int x = 0; x < 9; ++x) {
            List<Character> nums = new ArrayList<>();
            for (int y = 0; y < 9; ++y) {
                if (isFilledIn(board[y][x])) {
                    nums.add(board[y][x]);
                }
            }
            if (nums.size() != new HashSet<>(nums).size()) {
                return false;
            }
        }
        for (int yStart = 0; yStart < 3; ++yStart) {
            for (int xStart = 0; xStart < 3; ++xStart) {
                List<Character> nums = new ArrayList<>();
                for (int y = 3*yStart; y < 3*yStart + 3; ++y) {
                    for (int x = 3*xStart; x < 3*xStart + 3; ++x) {
                        if (isFilledIn(board[y][x])) {
                            nums.add(board[y][x]);
                        }
                    }
                }
                if (nums.size() != new HashSet<>(nums).size()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isFilledIn(char c) {
        return c >= '1' && c <= '9';
    }
}
