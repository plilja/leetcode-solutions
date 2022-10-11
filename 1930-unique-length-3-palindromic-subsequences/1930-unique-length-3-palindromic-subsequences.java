class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            int firstIndex = -1;
            int lastIndex = -1;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == c) {
                    if (firstIndex == -1) {
                        firstIndex = i;
                    }
                    lastIndex = i;
                }
            }
            Set<Character> charsBetween = new HashSet<>();
            for (int j = firstIndex + 1; j < lastIndex; ++j) {
                charsBetween.add(s.charAt(j));
            }
            result += charsBetween.size();
        }
        return result;
    }
}