/*


111111111
100000001

*/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        String sLeft = Integer.toBinaryString(left);
        String sRight = Integer.toBinaryString(right);
        if (sLeft.length() != sRight.length()) {
            return 0;
        }
        int n = sRight.length();
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (sRight.charAt(j) != sLeft.charAt(j)) {
                i = j;
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < sRight.length(); ++j) {
            if (j < i) {
                result.append(sRight.charAt(j));
            } else {
                result.append('0');
            }
        }
        return Integer.parseInt(result.toString(), 2);
    }
}