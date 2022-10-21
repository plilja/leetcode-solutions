class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[0].length; ++x) {
                if (board[y][x] == 'O' && !vis[y][x]) {
                    List<Point> region = new ArrayList<>();
                    Deque<Point> q = new ArrayDeque<>();
                    q.add(new Point(x, y));
                    boolean shouldBeFlipped = true;
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        if (vis[p.y][p.x]) {
                            continue;
                        }
                        vis[p.y][p.x] = true;
                        region.add(p);
                        for (Point d : DELTAS) {
                            Point n = new Point(p.x + d.x, p.y + d.y);
                            if (n.x < 0 || n.x >= board[0].length) {
                                shouldBeFlipped = false;
                                continue;
                            }
                            if (n.y < 0 || n.y >= board.length) {
                                shouldBeFlipped = false;
                                continue;
                            }
                            if (board[n.y][n.x] == 'O' && !vis[n.y][n.x]) {
                                q.add(n);
                            }
                        }
                    }
                    if (shouldBeFlipped) {
                        for (Point p : region) {
                            board[p.y][p.x] = 'X';
                        }
                    }
                }
            }
        }
        
    }
    
    private record Point(int x, int y) {
    }
}