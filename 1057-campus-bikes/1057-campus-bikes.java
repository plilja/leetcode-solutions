class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<WorkerBikePair> pairings = new ArrayList<>();
        for (int i = 0; i < workers.length; ++i) {
            int wx = workers[i][0];
            int wy = workers[i][1];
            for (int j = 0; j < bikes.length; ++j) {
                int bx = bikes[j][0];
                int by = bikes[j][1];
                int dist = Math.abs(wx - bx) + Math.abs(wy - by);
                WorkerBikePair wbp = new WorkerBikePair(i, j, dist);
                pairings.add(wbp);
            }
        }
        pairings.sort((a, b) -> {
            if (a.dist != b.dist) {
                return a.dist - b.dist;
            }
            if (a.worker != b.worker) {
                return a.worker - b.worker;
            }
            return a.bike - b.bike;
        });
        boolean[] usedBikes = new boolean[bikes.length];
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        for (var pair : pairings) {
            if (usedBikes[pair.bike]) {
                continue;
            }
            if (result[pair.worker] != -1) {
                continue;
            }
            result[pair.worker] = pair.bike;
            usedBikes[pair.bike] = true;
        }
        return result;
    }
    
    private record WorkerBikePair (int worker, int bike, int dist) {
    }
}