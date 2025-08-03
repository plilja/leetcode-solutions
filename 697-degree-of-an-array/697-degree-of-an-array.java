class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, ArrayList<Integer>> indicesPerNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            indicesPerNum.computeIfAbsent(n, k -> new ArrayList<>()).add(i);
        }
        int degree = indicesPerNum.values().stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElseThrow();
        int result = Integer.MAX_VALUE;
        for (var indices : indicesPerNum.values()) {
            for (int i = 0; i + degree - 1 < indices.size(); i++) {
                int a = indices.get(i);
                int b = indices.get(i + degree - 1);
                result = Math.min(result, b - a + 1);
            }
        }
        return result;
    }
}

