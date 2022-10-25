class Solution {
    private static final double EPS = 1e-9;
    private static final double BIG = 1e10;
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = new ArrayList<>();
        
        for (int i = 0; i < quality.length; ++i) {
            workers.add(new Worker(quality[i], wage[i]));
        }
        workers.sort((w1, w2) -> {
            double relativeWage1 = w1.wage / w1.quality;
            double relativeWage2 = w2.wage / w2.quality;
            if (Math.abs(relativeWage1 - relativeWage2) < EPS) {
                return 0;
            } else if (relativeWage1 < relativeWage2) {
                return -1;
            } else {
                return 1;
            }
        });
        PriorityQueue<Worker> highestEarnerQueue = new PriorityQueue<>((w1, w2) -> {
           return w2.quality - w1.quality; 
        });
        int qualitySum = 0;
        for (int i = 0; i < k - 1; ++i) {
            qualitySum += workers.get(i).quality;
            highestEarnerQueue.add(workers.get(i));
        }
        double result = BIG;
        for (int i = k - 1; i < workers.size(); ++i) {
            if (i >= k) {
                Worker w = highestEarnerQueue.poll();
                qualitySum -= w.quality;
            }
            Worker mostRelativelyExpensiveWorker = workers.get(i);
            highestEarnerQueue.add(mostRelativelyExpensiveWorker);
            qualitySum += mostRelativelyExpensiveWorker.quality;
            double relativeWage = mostRelativelyExpensiveWorker.wage / mostRelativelyExpensiveWorker.quality;
            result = Math.min(result, relativeWage * qualitySum);
        }
        return result;
    }
    
    private record Worker(int quality, double wage) {
    }
}