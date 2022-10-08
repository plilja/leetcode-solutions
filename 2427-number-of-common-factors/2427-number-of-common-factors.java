class Solution {
    public int commonFactors(int a, int b) {
        Set<Integer> factorsA = factors(a);
        Set<Integer> factorsB = factors(b);
        int result = 0;
        for (int i : factorsA) {
            if (factorsB.contains(i)) {
                result++;
            }
        }
        return result;
    }
    
    private Set<Integer> factors(int n) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}