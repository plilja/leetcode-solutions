class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; ++i) {
            String s = String.valueOf(i);
            StringBuilder reverse = new StringBuilder();
            for (int j = s.length() - 1; j >= 0; --j) {
                reverse.append(s.charAt(j));
            }
            int b = Integer.parseInt(reverse.toString());
            if (i + b == num) {
                return true;
            }
        }
        return false;
    }
}