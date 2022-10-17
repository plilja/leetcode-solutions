/*

2 * 2 * 3

2 * 6
4 * 3
2 * 2 * 3


*/
class Solution {
    public List<List<Integer>> getFactors(int n) {
        var result = solve(n);
        result.remove(List.of(n));
        return new ArrayList<>(result);
    }
    
    private Set<List<Integer>> solve(int n) {
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                Set<List<Integer>> sub = solve(n / i);
                Set<List<Integer>> result = new HashSet<>();
                for (List<Integer> subFactors : sub) {
                    List<Integer> copy = new ArrayList<>(subFactors);
                    copy.add(i);
                    Collections.sort(copy);
                    result.add(copy);
                    for (int j = 0; j < subFactors.size(); ++j) {
                        List<Integer> copy2 = new ArrayList<>(subFactors);
                        copy2.set(j, copy2.get(j) * i);
                        Collections.sort(copy2);
                        result.add(copy2);
                    }
                }
                return result;
            }
        }
        return new HashSet<>(Set.of(List.of(n)));
    }
    
}