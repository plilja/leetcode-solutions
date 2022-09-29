class Solution {
    public int findKthPositive(int[] arr, int k) {
        int rem = k;
        int prev = 0;
        for (int n : arr) {
            int diff = n - prev - 1;
            if (diff < rem) {
                rem -= diff;
            } else {
                return prev + rem;
            }
            prev = n;
        }
        return prev + rem;
    }
}