class Solution {
    public int findNthDigit(int n) {
        long nLong = (long) n;
        long a = 0;
        long b = n;
        while (true) {
            long middle = (a + b) / 2;
            long digitsSmaller = countDigitsSmaller(middle);
            String middleS = String.valueOf(middle);
            int digitsNum = middleS.length();
            if (digitsSmaller - digitsNum + 1 <= nLong && nLong <= digitsSmaller) {
                int rIdx = (int) (nLong - digitsSmaller);
                char c = middleS.charAt(middleS.length() + rIdx - 1);
                return (int) (c - '0');
            } else if (digitsSmaller < nLong) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
    }
    
    private long countDigitsSmaller(long num) {
        int numDigits = String.valueOf(num).length();
        long result = -1; // remove 0
        long prePower = 0;
        long power = 10;
        for (int i = 1; i < numDigits; ++i) {
            result += (power - prePower) * i;
            prePower = power;
            power *= 10;
        }
        result += numDigits * (num - prePower + 1);
        return result;
    }
}