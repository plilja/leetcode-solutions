class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (left < t.length() && t.charAt(left) != c) {
                left++;
            }
            if (left == t.length()) {
                return false;
            }
            left++;
        }
        return true;
    }
}
