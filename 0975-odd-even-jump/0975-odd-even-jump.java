class Solution {
    private static final int EVEN_JUMP = 0;
    private static final int ODD_JUMP = 1;
    
    public int oddEvenJumps(int[] arr) {
        boolean[][] dp = new boolean[arr.length][2];
        dp[arr.length - 1][EVEN_JUMP] = true;
        dp[arr.length - 1][ODD_JUMP] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[arr.length - 1], arr.length - 1);
        for (int i = arr.length - 2; i >= 0; --i) {
            int v = arr[i];
            var floor = map.floorEntry(v);
            if (floor != null) {
                dp[i][EVEN_JUMP] = dp[floor.getValue()][ODD_JUMP];
            }
            var ceiling = map.ceilingEntry(v);
            if (ceiling != null) {
                dp[i][ODD_JUMP] = dp[ceiling.getValue()][EVEN_JUMP];
            }
            map.put(v, i);
        }
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (dp[i][ODD_JUMP]) {
                result++;
            }
        }
        return result;
    }
}