class Solution {
    public int[][] candyCrush(int[][] board) {
        while (true) {
            List<Point> crush = new ArrayList<>();
            List<Point> next = new ArrayList<>();
            for (int y = 0; y < board.length; ++y) {
                for (int x = 0; x < board[y].length; ++x) {
                    if (board[y][x] == 0 || x == 0 || board[y][x - 1] != board[y][x]) {
                        if (next.size() >= 3) {
                            crush.addAll(next);
                        }
                        next.clear();
                    }
                    next.add(new Point(x, y));
                }
            }
            if (next.size() >= 3) {
                crush.addAll(next);
            }
            next.clear();
            for (int x = 0; x < board[0].length; ++x) {
                for (int y = 0; y < board.length; ++y) {
                    if (board[y][x] == 0 || y == 0 || board[y - 1][x] != board[y][x]) {
                        if (next.size() >= 3) {
                            crush.addAll(next);
                        }
                        next.clear();
                    }
                    next.add(new Point(x, y));
                }
            }
            if (next.size() >= 3) {
                crush.addAll(next);
            }
            next.clear();
            if (crush.isEmpty()) {
                break;
            }
            for (Point p : crush) {
                board[p.y][p.x] = -1;
            }
            for (int x = 0; x < board[0].length; ++x) {
                int store = board.length - 1;
                for (int y = board.length - 1; y >= 0; --y) {
                    if (board[y][x] >= 0) {
                        board[store][x] = board[y][x];
                        store--;
                    }
                }
                for (int y = 0; y <= store; ++y) {
                    board[y][x] = 0;
                }
            }
        }
        return board;
    }
    
    private record Point(int x, int y) {
    }
}