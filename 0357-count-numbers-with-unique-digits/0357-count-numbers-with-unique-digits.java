class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 1; // when n == 0 only x == 0 is valid
        if (n >= 1) {
            result += 9;
        }
        for (int i = 2; i <= n; i++) {
            int picksWithoutZero = binomial(9, i);
            int waysToScramble = factorial(i);
            result += picksWithoutZero * waysToScramble;
            int picksWithZero = binomial(9, i - 1);
            int waysToScrambleButZeroNeverFirst = factorial(i - 1) * (i - 1);
            result += picksWithZero * waysToScrambleButZeroNeverFirst;
        }
        return result;
    }

    private int binomial(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(5));
    }
}
