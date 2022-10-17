class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        pick(new ArrayList<>(), 1, n, k, result);
        return result;
    }
    
    private void pick(List<Integer> currentPick, int start, int n, int k, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(currentPick));
        } else {
            for (int i = start; i <= n; ++i) {
                currentPick.add(i);
                pick(currentPick, i + 1, n, k - 1, result);
                currentPick.remove(currentPick.size() - 1);
            }
        }
    }
}
