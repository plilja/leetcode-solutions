class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> positions = new HashMap<>();
        for (int i = 0; i < stones.length; ++i) {
            positions.put(stones[i], new HashSet<>());
        }
        positions.get(stones[0]).add(0);
        for (int i = 0; i < stones.length; ++i) {
            int stone = stones[i];
            for (int jump : positions.get(stone)) {
                for (int j = -1; j <= 1; ++j) {
                    int next = stone + jump + j;
                    if (next > stone && positions.containsKey(next)) {
                        positions.get(next).add(jump + j);
                    }
                }
            }
        }
        return !positions.get(stones[stones.length - 1]).isEmpty();
    }
}