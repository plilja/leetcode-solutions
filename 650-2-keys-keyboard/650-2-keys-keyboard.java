class Solution {
    public int minSteps(int n) {
        int[] m = new int[n + 1];
        Arrays.fill(m, n + 1);
        m[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n / i; j++) {
                m[i * j] = Math.min(m[i * j], m[i] + j);
            }
        }
        return m[n];
    }
}

