import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        var pq = new PriorityQueue<Integer[]>((a, b) -> {
            int aSize = a[1] - a[0];
            int bSize = b[1] - b[0];
            return aSize - bSize;
        });
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int[] interval : intervals) {
            pq.add(new Integer[]{interval[0], interval[1]});
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        var unassigned = new TreeMap<Integer, Integer>();
        unassigned.put(min, max);
        int[] ans = new int[max + 1];
        Arrays.fill(ans, -1);
        while (!pq.isEmpty()) {
            var interval = pq.poll();
            int from = interval[0];
            int to = interval[1];
            int j = from;
            while (j <= to) {
                var floor = unassigned.floorEntry(j);
                if (floor != null && floor.getValue() >= j) {
                    for (int k = j; k <= Math.min(to, floor.getValue()); ++k) {
                        ans[k] = to - from + 1;
                    }
                    unassigned.remove(floor.getKey());
                    if (j > floor.getKey() && to < floor.getValue()) {
                        unassigned.put(floor.getKey(), j - 1);
                        unassigned.put(to + 1, floor.getValue());
                    } else if (j > floor.getKey()) {
                        unassigned.put(floor.getKey(), j - 1);
                    } else if (to < floor.getValue()) {
                        unassigned.put(to + 1, floor.getValue());
                    }
                    j = floor.getValue() + 1;
                } else {
                    var next = unassigned.ceilingEntry(j + 1);
                    if (next == null) {
                        break;
                    } else {
                        j = next.getKey();
                    }
                }
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int q = queries[i];
            result[i] = ans[q];
        }
        return result;
    }

    private record Entry(int size, int to) {
    }
}