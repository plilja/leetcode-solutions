class Solution {
    public int minTotalDistance(int[][] grid) {
        int[] yFriends = new int[grid.length];
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == 1) {
                    yFriends[y]++;
                }
            }
        }
        int[] xFriends = new int[grid[0].length];
        for (int x = 0; x < grid[0].length; ++x) {
            for (int y = 0; y < grid.length; ++y) {
                if (grid[y][x] == 1) {
                    xFriends[x]++;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int y = 0; y < grid.length; ++y) {
            int yCost = 0;
            for (int y2 = 0; y2 < grid.length; ++y2) {
                yCost += yFriends[y2] * Math.abs(y - y2);
            }
            for (int x = 0; x < grid[0].length; ++x) {
                int cost = yCost;
                for (int x2 = 0; x2 < grid[0].length; ++x2) {
                    cost += xFriends[x2] * Math.abs(x - x2);
                }
                result = Math.min(result, cost);
            }
        }
        return result;
    }
}
