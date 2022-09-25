class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; ++i) {
            if (s.length() % i == 0) {
                String pattern = s.substring(0, i);
                boolean possible = true;
                for (int j = 0; j < s.length() && possible; ++j) {
                    if (s.charAt(j) != pattern.charAt(j % pattern.length())) {
                        possible = false;
                    }
                }
                if (possible) {
                    return true;
                }
            }
        }
        return false;
    }
}