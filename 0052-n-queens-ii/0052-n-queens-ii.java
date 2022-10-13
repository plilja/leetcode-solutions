class Solution {
    public int totalNQueens(int n) {
        return solve(new ArrayList<>(), n);
    }
    
    private int solve(List<Integer> solution, int n) {
        if (solution.size() == n) {
            return 1;
        } else {
            Set<Integer> blocked = new HashSet<>();
            int d = solution.size();
            for (int i = 0; i < d; ++i) {
                int k = solution.get(i);
                blocked.add(k);
                int diff = d - i;
                blocked.add(k + diff);
                blocked.add(k - diff);
            }
            int result = 0;
            for (int i = 0; i < n; ++i) {
                if (!blocked.contains(i)) {
                    solution.add(i);
                    result += solve(solution, n);
                    solution.remove(solution.size() - 1);
                }
            }
            return result;
        }
    }
}