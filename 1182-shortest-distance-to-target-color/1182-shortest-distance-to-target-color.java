class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, TreeSet<Integer>> colorToIndexes = new HashMap<>();
        for (int i = 0; i < colors.length; ++i) {
            colorToIndexes.computeIfAbsent(colors[i], k -> new TreeSet<>()).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int index = query[0];
            int color = query[1];
            TreeSet<Integer> indexes = colorToIndexes.get(color);
            if (indexes == null) {
                result.add(-1);
            } else {
                Integer floor = indexes.floor(index);
                Integer ceil = indexes.ceiling(index);
                if (floor != null && ceil != null) {
                    result.add(Math.min(ceil - index, index - floor));
                } else if (floor != null) {
                    result.add(index - floor);
                } else {
                    result.add(ceil - index);
                }
            }
        }
        return result;
    }
}