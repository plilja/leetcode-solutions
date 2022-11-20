class Solution {
    public int[][] minScore(int[][] grid) {
        int[] rowmax = new int[grid.length];
        int[] colmax = new int[grid[0].length];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                pq.add(new Cell(x, y, grid[y][x]));
            }
        }
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int val = Math.max(rowmax[cell.y], colmax[cell.x]) + 1;
            grid[cell.y][cell.x] = val;
            rowmax[cell.y] = val;
            colmax[cell.x] = val;
        }
        return grid;
        
    }
    
    private record Cell(int x, int y, int val) {
    }
}