class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 0; j < prev.size() - 1; ++j) {
                next.add(prev.get(j) + prev.get(j + 1));
            }
            next.add(1);
            result.add(next);
        }
        return result;
    }
}
