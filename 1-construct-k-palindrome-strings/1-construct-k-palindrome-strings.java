class Solution {
    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charCounts.merge(c, 1, (a, b) -> a + b);
        }
        int minPalindromesNeeded = 0;
        int maxPalindromesPossible = 0;
        for (int count : charCounts.values()) {
            if (count % 2 == 1) {
                minPalindromesNeeded++;
            }
            maxPalindromesPossible += count;
        }
        return k <= maxPalindromesPossible && k >= minPalindromesNeeded;
    }
}
