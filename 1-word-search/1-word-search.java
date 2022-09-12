class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[y].length; ++x) {
                if (board[y][x] == word.charAt(0)) {
                    if (dfs(board, new Point(x, y), word, 0, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, Point p, String word, int wordStart, Set<Point> visited) {
        if (visited.contains(p)) {
            return false;
        }
        char c = word.charAt(wordStart);
        if (board[p.y()][p.x()] != c) {
            return false;
        }
        if (wordStart == word.length() - 1) {
            return true;
        }
        visited.add(p);
        boolean result = false;
        for (Point d : DELTAS) {
            Point n = new Point(p.x() + d.x(), p.y() + d.y());
            if (n.x() >= 0 && n.x() < board[0].length && n.y() >= 0 && n.y() < board.length) {
                if (dfs(board, n, word, wordStart + 1, visited)) {
                    result = true;
                    break;
                }
            }
        }
        visited.remove(p);
        return result;
    }
    
    private record Point(int x, int y) {}
}
