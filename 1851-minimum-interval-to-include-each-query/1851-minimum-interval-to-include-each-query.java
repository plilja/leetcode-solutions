import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        var sortedQueries = new ArrayList<IndexAndValue>();
        for (int i = 0; i < queries.length; ++i) {
            int q = queries[i];
            sortedQueries.add(new IndexAndValue(i, q));
        }
        sortedQueries.sort(Comparator.comparingInt(a -> a.value));
        var sortedIntervals = new ArrayList<Integer[]>();
        for (int[] interval : intervals) {
            sortedIntervals.add(new Integer[]{interval[0], interval[1]});
        }
        sortedIntervals.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        var minimumInterval = new PriorityQueue<Integer[]>((a, b) -> {
            int aSize = a[1] - a[0];
            int bSize = b[1] - b[0];
            if (aSize != bSize) {
                return aSize - bSize;
            } else {
                return a[1] - b[1];
            }
        });
        int[] result = new int[queries.length];
        int nextInterval = 0;
        for (var item : sortedQueries) {
            while (nextInterval < sortedIntervals.size() && sortedIntervals.get(nextInterval)[0] <= item.value) {
                Integer[] interval = sortedIntervals.get(nextInterval);
                nextInterval++;
                minimumInterval.add(interval);
            }
            while (!minimumInterval.isEmpty() && minimumInterval.peek()[1] < item.value) {
                minimumInterval.poll();
            }
            if (minimumInterval.isEmpty()) {
                result[item.index] = -1;
            } else {
                result[item.index] = minimumInterval.peek()[1] - minimumInterval.peek()[0] + 1;
            }
        }
        return result;
    }

    private record IndexAndValue(int index, int value) {
    }
}
