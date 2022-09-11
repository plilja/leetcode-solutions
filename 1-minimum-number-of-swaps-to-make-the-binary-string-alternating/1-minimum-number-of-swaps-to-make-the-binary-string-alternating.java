class Solution {
    public int minSwaps(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int c = (int) (s.charAt(i) - '0');
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        if (s.length() % 2 == 0) {
            if (oneCount != zeroCount) {
                return -1;
            }
            return Math.min(numSwaps(s, '0'), numSwaps(s, '1'));
        } else {
            if (Math.abs(zeroCount - oneCount) != 1) {
                return -1;
            }
            if (zeroCount > oneCount) {
                return numSwaps(s, '0');
            } else {
                return numSwaps(s, '1');
            }
        }
    }
    
    private int numSwaps(String s, char first) {
        int result = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != first) {
                result++;
            }
        }
        return result;
    }
}
