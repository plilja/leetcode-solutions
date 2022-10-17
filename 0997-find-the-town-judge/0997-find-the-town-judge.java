class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustedCount = new int[n];
        int[] trustCount = new int[n];
        for (int[] edge : trust) {
            trustedCount[edge[1] - 1]++;
            trustCount[edge[0] - 1]++;
        }
        for (int i = 0; i < n; ++i) {
            if (trustedCount[i] == n - 1 && trustCount[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}