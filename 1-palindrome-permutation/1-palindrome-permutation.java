class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charToCount.merge(c, 1, (a, b) -> a + b);
        }
        int numOdd = 0;
        for (int count : charToCount.values()) {
            if (count % 2 == 1) {
                numOdd++;
            }
        }
        return numOdd <= 1;
    }
}
