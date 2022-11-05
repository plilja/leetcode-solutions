class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        Map<Character, Integer> chars = new HashMap<>();
        for (int j = 0; j < k; ++j) {
            chars.merge(s.charAt(j), 1, (a, b) -> a + b);
        }
        int result = 0;
        if (isUnique(chars)) {
            result++;
        }
        for (int i = k; i < s.length(); ++i) {
            chars.merge(s.charAt(i), 1, (a, b) -> a + b);
            chars.merge(s.charAt(i - k), -1, (a, b) -> a + b);
            if (isUnique(chars)) {
                result++;
            }
        }
        return result;
    }
    
    private boolean isUnique(Map<Character, Integer> chars) {
        for (int count : chars.values()) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}