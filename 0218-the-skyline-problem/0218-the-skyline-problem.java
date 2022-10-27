class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<Integer>> heights = new TreeMap<>();
        for (int[] b : buildings) {
            heights.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[2]);
            heights.computeIfAbsent(b[1], k -> new ArrayList<>()).add(-b[2]);
        }
        List<List<Integer>> skyline = new ArrayList<>();
        TreeMap<Integer, Integer> currentHeight = new TreeMap<>();
        for (var entry : heights.entrySet()) {
            int x = entry.getKey();
            for (int h : entry.getValue()) {
                if (h > 0) {
                    currentHeight.merge(h, 1, (a, b) -> a + b);
                } else {
                    int newCount = currentHeight.merge(-h, -1, (a, b) -> a + b);
                    if (newCount == 0) {
                        currentHeight.remove(-h);
                    }
                }
            }
            if (currentHeight.isEmpty()) {
                skyline.add(List.of(x, 0));
            } else if (skyline.isEmpty() || skyline.get(skyline.size() - 1).get(1) != currentHeight.lastKey()) {
                skyline.add(List.of(x, currentHeight.lastKey()));
            }
        }
        return skyline;
    }
}