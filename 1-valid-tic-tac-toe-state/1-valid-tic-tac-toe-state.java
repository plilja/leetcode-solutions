class Solution {
    record Point(
        int x,
        int y
    ){}
    
    private static final List<List<Point>> WINNING_LINES = winningLines();
        
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        for (String row : board) {
            for (int i = 0; i < 3; ++i) {
                char c = row.charAt(i);
                if (c == 'O') {
                    oCount++;
                }
                if (c == 'X') {
                    xCount++;
                }
            }
        }
        if (xCount != oCount && xCount != oCount + 1) {
            return false;
        }
        Set<Character> winners = new HashSet<>();
        List<List<Point>> winLines = new ArrayList<>();
        for (List<Point> line : WINNING_LINES) {
            var first = line.get(0);
            char firstChar = board[first.y()].charAt(first.x());
            if (firstChar != ' ') {
                boolean winner = true;
                for (int i = 1; i < 3 && winner; ++i) {
                    Point p = line.get(i);
                    winner = board[p.y()].charAt(p.x()) == firstChar;
                }
                if (winner) {
                    winLines.add(line);
                    winners.add(firstChar);
                }
            }
        }
        if (winners.size() == 0) {
            return true;
        }
        if (winners.size() > 1) {
            return false;
        }
        char winner = winners.iterator().next();
        if (winner == 'X' && xCount == oCount) {
            return false;
        }
        if (winner == 'O' && xCount != oCount) {
            return false;
        }
        if (winLines.size() <= 1) {
            return true;
        }
        Set<Point> commonWinPoint = new HashSet<>(winLines.get(0));
        for (int i = 1; i < winLines.size(); ++i) {
            commonWinPoint.retainAll(winLines.get(i));
        }
        return commonWinPoint.size() == 1;
    }
    
    private static List<List<Point>> winningLines() {
        List<List<Point>> result = new ArrayList<>();
        for (int y = 0; y < 3; ++y) {
            List<Point> row = new ArrayList<>();
            for (int x = 0; x < 3; ++x) {
                row.add(new Point(x, y));
            }
            result.add(row);
        }
        for (int x = 0; x < 3; ++x) {
            List<Point> row = new ArrayList<>();
            for (int y = 0; y < 3; ++y) {
                row.add(new Point(x, y));
            }
            result.add(row);
        }
        result.add(List.of(
            new Point(0, 0),
            new Point(1, 1),
            new Point(2, 2)
        ));
        result.add(List.of(
            new Point(2, 0),
            new Point(1, 1),
            new Point(0, 2)
        ));
        return result;
        
    }
    
}
