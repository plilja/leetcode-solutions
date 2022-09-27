class Solution {
    public int tribonacci(int n) {
        int[] arr = new int[]{0, 1, 1};
        if (n <= 2) {
            return arr[n];
        }
        for (int i = 3; i <= n; ++i) {
            int t = arr[0] + arr[1] + arr[2];
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = t;
        }
        return arr[2];
    }
}