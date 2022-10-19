class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1),
        new Point(1, 1),
        new Point(1, -1),
        new Point(-1, 1),
        new Point(-1, -1)
    );
    
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        for (Point d : DELTAS) {
            Point p = new Point(cMove + d.x, rMove + d.y);
            boolean valid = true;
            boolean oppositeColorFound = false;
            boolean otherEndFound = false;
            while (p.x >= 0 && p.x < board[0].length && p.y >= 0 && p.y < board.length) {
                if (board[p.y][p.x] == '.') {
                    break;
                }
                if (board[p.y][p.x] != color) {
                    if (otherEndFound) {
                        valid = false;
                        break;
                    }
                    oppositeColorFound = true;
                }
                if (board[p.y][p.x] == color) {
                    if (!oppositeColorFound) {
                        valid = false;
                        break;
                    }
                    otherEndFound = true;
                }
                p = new Point(p.x + d.x, p.y + d.y);
            }
            if (oppositeColorFound && otherEndFound) {
                return true;
            }
        }
        return false;
    }
    
    private record Point(int x, int y) {
    }
}