class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = sum(aliceSizes);
        int bobTotal = sum(bobSizes);
        Set<Integer> bobs = new HashSet<>();
        for (int n : bobSizes) {
            bobs.add(n);
        }
        for (int n : aliceSizes) {
            int x = (bobTotal - aliceTotal + 2 * n) / 2;
            if (bobs.contains(x) && aliceTotal - n + x == bobTotal -x + n) {
                return new int[]{n, x};
            }
        }
        throw new IllegalArgumentException("No solution found");
    }
    
    private int sum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            result += arr[i];
        }
        return result;
    }
}
