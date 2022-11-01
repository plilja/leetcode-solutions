class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        Map<Integer, Set<Integer>> hasPositive = new HashMap<>();
        Map<Integer, Set<Integer>> hasNegative = new HashMap<>();
        dp.computeIfAbsent(stones.length, k -> new HashSet<>()).add(0);
        for (int i = stones.length - 1; i >= 0; --i) {
            int stone = stones[i];
            var currDp = dp.computeIfAbsent(i, k -> new HashSet<>());
            var currNeg = dp.computeIfAbsent(i, k -> new HashSet<>());
            var currPos = dp.computeIfAbsent(i, k -> new HashSet<>());
            var nextDp = dp.getOrDefault(i + 1, Set.of());
            var nextNeg = dp.getOrDefault(i + 1, Set.of());
            var nextPos = dp.getOrDefault(i + 1, Set.of());
            for (int j = -sum; j <= sum; ++j) {
                if (nextDp.contains(j)) {
                    currDp.add(j - stone);
                    currNeg.add(j - stone);
                    currDp.add(j + stone);
                    currPos.add(j + stone);
                }
            }
        }
        var lastDp = dp.getOrDefault(0, Set.of());
        var lastNeg = dp.getOrDefault(0, Set.of());
        var lastPos = dp.getOrDefault(0, Set.of());
        for (int j = 0; j <= sum; ++j) {
            if (lastDp.contains(j) && lastNeg.contains(j) && lastPos.contains(j)) {
                return j;
            }
        }
        return -1;
    }
}