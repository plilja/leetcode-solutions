class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        solve(results, new ArrayList<>(), n);
        return results;
    }
    
    private void solve(List<List<String>> results, List<Integer> solution, int n) {
        if (solution.size() == n) {
            results.add(toString(solution, n));
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
            for (int i = 0; i < n; ++i) {
                if (!blocked.contains(i)) {
                    solution.add(i);
                    solve(results, solution, n);
                    solution.remove(solution.size() - 1);
                }
            }
        }
    }
    
    private List<String> toString(List<Integer> solution, int n) {
        List<String> result = new ArrayList<>();
        for (int k : solution) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                if (i == k) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
