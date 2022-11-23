/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int y = 1; y <= 1000; ++y) {
            int a = 1;
            int b = 1000;
            while (a < b) {
                int middle = (a + b) / 2;
                int v = customfunction.f(middle, y);
                if (v == z) {
                    a = middle;
                    break;
                }
                if (v < z) {
                    a = middle + 1;
                } else {
                    b = middle;
                }
            }
            if (customfunction.f(a, y) == z) {
                result.add(List.of(a, y));
            }
        }
        return result;
    }
}