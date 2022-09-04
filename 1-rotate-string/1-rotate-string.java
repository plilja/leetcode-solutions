class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); ++i) {
            boolean match = true;
            for (int j = 0; j < s.length(); ++j) {
                int idx = (j - i + s.length()) % s.length();
                char cSource = s.charAt(idx);
                char cTarget = goal.charAt(j);
                if (cSource != cTarget) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
