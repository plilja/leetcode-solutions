class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(0, -1),
        new Point(1, -1),
        new Point(1, 0),
        new Point(1, 1),
        new Point(0, 1),
        new Point(-1, 1),
        new Point(-1, 0),
        new Point(-1, -1)
    );
    private static char UNREVEALED_MINE = 'M';
    private static char UNREVEALED_EMPTY = 'E';
    private static char REVEALED_EMPTY_NO_ADJ = 'B';
    private static char REVEALED_MINE = 'X';
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        if (board[y][x] == UNREVEALED_MINE) {
            board[y][x] = REVEALED_MINE;
        } else if (board[y][x] == UNREVEALED_EMPTY) {
            Deque<Point> q = new ArrayDeque<>();
            q.add(new Point(x, y));
            while (!q.isEmpty()) {
                Point p = q.poll();
                if (board[p.y()][p.x()] != UNREVEALED_EMPTY) {
                    continue;
                }
                List<Point> neighbours = new ArrayList<>();
                for (Point d : DELTAS) {
                    Point n = new Point(p.x() + d.x(), p.y() + d.y());
                    if (n.x() >= 0 && 
                        n.x() < board[0].length && 
                        n.y() >= 0 && 
                        n.y() < board.length) {
                        neighbours.add(n);
                    }
                }
                int adjMines = 0;

                for (Point n : neighbours) {
                    if (board[n.y()][n.x()] == UNREVEALED_MINE) {
                        adjMines++;
                    }
                }
                if (adjMines == 0) {
                    q.addAll(neighbours);
                    board[p.y()][p.x()] = REVEALED_EMPTY_NO_ADJ;
                } else {
                    board[p.y()][p.x()] = (char) ((int)'0' + adjMines);
                }
            }
        }
        return board;
    }
    
    private record Point(int x, int y) {};
}
