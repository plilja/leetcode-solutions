class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int lim = gcd(k, n);
        for (int i = 0; i < lim; ++i) {
            int curr = (i + k) % n;
            int mem = nums[curr];
            nums[curr] = nums[i];
            while (curr != i) {
                int tmp = nums[(curr + k) % n];
                nums[(curr + k) % n] = mem;
                mem = tmp;
                curr = (curr + k) % n;
            }
        }
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}