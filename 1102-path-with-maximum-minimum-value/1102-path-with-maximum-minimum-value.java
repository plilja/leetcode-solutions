class Solution {
    private static final int[] DXS = new int[]{1, 0, -1,  0};
    private static final int[] DYS = new int[]{0, 1,  0, -1};
    
    public int maximumMinimumPath(int[][] grid) {
        PriorityQueue<Elem> pq = new PriorityQueue<>((a, b) -> {
            return b.score - a.score;
        });
        pq.add(new Elem(0, 0, grid[0][0]));
        int[][] score = new int[grid.length][grid[0].length];
        while (!pq.isEmpty()) {
            Elem elem = pq.poll();
            int x = elem.x;
            int y = elem.y;
            if (score[y][x] >= elem.score) {
                continue;
            }
            score[y][x] = elem.score;
            for (int i = 0; i < 4; ++i) {
                int dx = DXS[i];
                int dy = DYS[i];
                if (x + dx < 0 || x + dx >= grid[0].length) {
                    continue;
                }
                if (y + dy < 0 || y + dy >= grid.length) {
                    continue;
                }
                pq.add(new Elem(x + dx, y + dy, Math.min(elem.score, grid[y + dy][x + dx])));
            }
            
        }
        return score[grid.length - 1][grid[0].length - 1];
    }
    
    private record Elem(int x, int y, int score) {
    }
}