class Solution {
    public int arrangeCoins(int n) {
        //k * (k + 1) <= 2 * n;
        //k**2 + k - 2n == 0
        
        long nl = (long) n;
        double num = -1L + Math.sqrt(1L + 8L*nl);
        return (int) (num / 2D);
    }
}
