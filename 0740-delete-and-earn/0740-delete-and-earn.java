class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int n : nums) {
            m.merge(n, 1, (a, b) -> a + b);
        }
        int[] prev = new int[2];
        int prevKey = -1;
        for (var entry : m.entrySet()) {
            int val;
            if (prevKey + 1 == entry.getKey()) {
                val = prev[0] + entry.getKey() * entry.getValue();
            } else {
                val = Math.max(prev[0], prev[1]) + entry.getKey() * entry.getValue();
            }
            prev[0] = Math.max(prev[0], prev[1]);
            prev[1] = val;
            prevKey = entry.getKey();
        }
        return Math.max(prev[0], prev[1]);
    }
}