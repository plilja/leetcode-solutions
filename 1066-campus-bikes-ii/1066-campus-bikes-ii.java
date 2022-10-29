class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] usedBikes = new boolean[bikes.length];
        return solve(workers, bikes, 0, usedBikes);
    }
    
    private int solve(int[][] workers, int[][] bikes, int nextWorker, boolean[] usedBikes) {
        if (nextWorker == workers.length) {
            return 0;
        }
        int wx = workers[nextWorker][0];
        int wy = workers[nextWorker][1];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; ++i) {
            if (!usedBikes[i]) {
                usedBikes[i] = true;
                int bx = bikes[i][0];
                int by = bikes[i][1];
                int dist = Math.abs(wx - bx) + Math.abs(wy - by);
                result = Math.min(result, dist + solve(workers, bikes, nextWorker + 1, usedBikes));
                usedBikes[i] = false;
            }
        }
        return result;
    }
}