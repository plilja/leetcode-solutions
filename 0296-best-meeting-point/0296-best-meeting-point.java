class Solution {
    public int minTotalDistance(int[][] grid) {
        int[][] costsLeft = new int[grid.length][grid[0].length];
        int[][] peopleLeft = new int[grid.length][grid[0].length];
        int[][] costsRight = new int[grid.length][grid[0].length];
        int[][] peopleRight = new int[grid.length][grid[0].length];
        calculateCosts(grid, costsLeft, peopleLeft, 0, 1);
        calculateCosts(grid, costsRight, peopleRight, grid[0].length - 1, -1);
        int result = Integer.MAX_VALUE;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                int cost = costsRight[y][x];
                if (x > 0) {
                    cost += costsLeft[y][x - 1] + peopleLeft[y][x - 1];
                }
                result = Math.min(result, cost);
            }
        }
        return result;
    }
    
    private void calculateCosts(int[][] grid, int[][] costs, int[][] people, int startX, int xDelta) {
        for (int x = startX; x < grid[0].length && x >= 0; x += xDelta) {
            for (int y = 0; y < grid.length; ++y) {
                int costDown = 0;
                int peopleDown = 0;
                for (int y2 = 0; y2 <= y; ++y2) {
                    costDown += peopleDown;
                    peopleDown += grid[y2][x];
                }
                int costUp = 0;
                int peopleUp = 0;
                for (int y2 = grid.length - 1; y2 >= y; --y2) {
                    costUp += peopleUp;
                    peopleUp += grid[y2][x];
                }
                costs[y][x] = costDown + costUp;
                people[y][x] = peopleDown + peopleUp - grid[y][x];
                if (x - xDelta >= 0 && x - xDelta < grid[0].length) {
                    costs[y][x] += costs[y][x - xDelta] + people[y][x - xDelta];
                    people[y][x] += people[y][x - xDelta];
                }
            }
        }
    }
}