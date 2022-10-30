class Solution {
    public int maxPower(String s) {
        char prev = '?';
        int start = -1;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != prev) {
                start = i;
                prev = c;
            }
            result = Math.max(i - start + 1, result);
        }
        return result;
    }
}