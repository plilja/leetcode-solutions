class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; ++i) {
            String b = Integer.toBinaryString(i);
            if (s.indexOf(b) == -1) {
                return false;
            }
        }
        return true;
    }
}