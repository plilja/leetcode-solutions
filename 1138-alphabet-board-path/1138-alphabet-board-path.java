class Solution {
    private char[][] board = new char[][]{
        new char[]{'a','b','c','d','e'},
        new char[]{'f','g','h','i','j'},
        new char[]{'k','l','m','n','o'},
        new char[]{'p','q','r','s','t'},
        new char[]{'u','v','w','x','y'},
        new char[]{'z'}
    };
        
    public String alphabetBoardPath(String target) {
        Map<Character, Point> charToPoint = new HashMap<>();
        for (int y = 0; y < board.length; ++y) {
            for (int x = 0; x < board[y].length; ++x) {
                char c = board[y][x];
                charToPoint.put(c, new Point(x, y));
            }
        }
        StringBuilder result = new StringBuilder();
        Point current = new Point(0, 0);
        for (int i = 0; i < target.length(); ++i) {
            char c = target.charAt(i);
            Point pos = charToPoint.get(c);
            if (board[current.y][current.x] == 'z') {
                int dy = current.y - pos.y;
                for (int j = 0; j < dy; ++j) {
                    result.append('U');
                }
                int dx = pos.x - current.x;
                for (int j = 0; j < dx; ++j) {
                    result.append('R');
                }
                result.append("!");
            } else {
                int dx = Math.abs(current.x - pos.x);
                char horizontalDirection = current.x < pos.x ? 'R' : 'L';  
                for (int j = 0; j < dx; ++j) {
                    result.append(horizontalDirection);
                }
                int dy = Math.abs(current.y - pos.y);
                char verticalDirection = current.y < pos.y ? 'D' : 'U';  
                for (int j = 0; j < dy; ++j) {
                    result.append(verticalDirection);
                }
                result.append("!");
            }
            current = pos;
        }
        return result.toString();
    }
    
    private record Point(int x, int y) {
    }
}