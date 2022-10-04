class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> bricksNeeded = new PriorityQueue<>((a, b) -> b - a);
        int sumBricksNeeded = 0;
        int sumLaddersNeeded = 0;
        int i = 1;
        while (i < heights.length) {
            int h1 = heights[i - 1];
            int h2 = heights[i];
            if (h1 < h2) {
                int cost = h2 - h1;
                if (sumBricksNeeded + cost <= bricks) {
                    bricksNeeded.add(cost);
                    sumBricksNeeded += cost;
                } else if (sumLaddersNeeded < ladders) {
                    if (!bricksNeeded.isEmpty() && bricksNeeded.peek() > cost) {
                        int p = bricksNeeded.poll();
                        bricksNeeded.add(cost);
                        sumBricksNeeded -= p;
                        sumBricksNeeded += cost;
                    }  
                    sumLaddersNeeded++;
                } else {
                    break;
                }
            }
            i++;
        }
        return i - 1;
    }
}