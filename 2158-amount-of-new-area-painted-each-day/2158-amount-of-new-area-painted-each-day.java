import java.util.*;

class Solution {
    public int[] amountPainted(int[][] paint) {
        // painted[x] = y means painted from x (inclusive) to y (exclusive)
        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> painted = new TreeMap<>(); 
        for (int[] interval : paint) {
            int x = interval[0];
            int y = interval[1];
            ArrayList<Integer[]> overlapping = new ArrayList<>();
            Integer firstSmaller = painted.floorKey(x - 1);
            SortedMap<Integer, Integer> potentiallyOverlapping;
            if (firstSmaller == null) {
                potentiallyOverlapping = painted;
            } else {
                potentiallyOverlapping = painted.tailMap(firstSmaller);
            }
            int totalPaint = y - x;
            int minNewInterval = x;
            int maxNewInterval = y;
            for (var entry : potentiallyOverlapping.entrySet()) {
                int from = entry.getKey();
                int to = entry.getValue();
                if (from > y) {
                    break;
                }
                if ((from <= x && to > x) || x <= from && y > from) {
                    overlapping.add(new Integer[]{from, to});
                    minNewInterval = Math.min(minNewInterval, from);
                    maxNewInterval = Math.max(maxNewInterval, to);
                    if (from < x) {
                        totalPaint -= Math.min(y, to) - x;
                    } else {
                        totalPaint -= Math.min(y, to) - from;
                    }
                } 
            }
            for (Integer[] overlap : overlapping) {
                painted.remove(overlap[0]);
            }
            painted.put(minNewInterval, maxNewInterval);
            result.add(totalPaint);
        }
        int[] arrayResult = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }
}
