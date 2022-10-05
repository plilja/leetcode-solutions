class Solution {
    private static final int DIV = 10000;
    
    public int countDigitOne(int n) {
        int k = 0;
        int result = 0;
        int r = countDigitOnes(DIV - 1);
        while (k <= n) {
            if (k % DIV == 0 && k + DIV - 1 < n) {
                int h = countOnesInNumber(k);
                result += h * (DIV - 1) + r;
                k += DIV - 1;
            } else {
                result += countOnesInNumber(k);
                k++;
            }
        }
        return result;
    }
    
    private int countDigitOnes(int n) {
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            result += countOnesInNumber(i);
        }
        return result;
    }
    
    private int countOnesInNumber(int n) {
        int result = 0;
        int k = n;
        while (k > 0) {
            if (k % 10 == 1) {
                result++;
            }
            k /= 10;
        }
        return result;
    }
}