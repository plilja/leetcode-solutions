class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        long neededArea = determineArea(rectangles);
        long actualArea = 0;
        for (int[] rectangle : rectangles) {
            actualArea += (((long) rectangle[2]) - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }
        if (neededArea != actualArea) {
            return false;
        }
        Arrays.sort(rectangles, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[2] - b[2];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(j -> rectangles[j][2]));
        TreeMap<Integer, Integer> yIntervals = new TreeMap<>();
        for (int i = 0; i < rectangles.length; ++i) {
            int[] rectangle = rectangles[i];
            while (!pq.isEmpty() && rectangles[pq.peek()][2] <= rectangle[0]) {
                int j = pq.poll();
                yIntervals.remove(rectangles[j][1]);
            }
            var floor = yIntervals.floorEntry(rectangle[1]);
            if (floor != null && floor.getValue() > rectangle[1]) {
                return false;
            }
            var ceiling = yIntervals.ceilingEntry(rectangle[1]);
            if (ceiling != null && ceiling.getKey() < rectangle[3]) {
                return false;
            }
            yIntervals.put(rectangle[1], rectangle[3]);
            pq.add(i);
        }
        return true;
    }

    private long determineArea(int[][] rectangles) {
        long minX = Integer.MAX_VALUE;
        long maxX = Integer.MIN_VALUE;
        long minY = Integer.MAX_VALUE;
        long maxY = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            minX = Math.min(minX, rectangle[0]);
            maxX = Math.max(maxX, rectangle[2]);
            minY = Math.min(minY, rectangle[1]);
            maxY = Math.max(maxY, rectangle[3]);
        }
        return (maxY - minY) * (maxX - minX);
    }
}
