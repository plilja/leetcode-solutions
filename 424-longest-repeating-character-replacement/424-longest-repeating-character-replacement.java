class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charToCount = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charToCount.merge(c, 1, (a, b) -> a + b);
            while (true) {
                int numCharsInWindow = i - left + 1;
                int biggestCount = 0;
                for (char c2 = 'A'; c2 <= 'Z'; ++c2) {
                    biggestCount = Math.max(biggestCount, charToCount.getOrDefault(c2, 0));
                }
                int needsToBeRemoved = numCharsInWindow - biggestCount;
                if (needsToBeRemoved <= k) {
                    break;
                }
                char remC = s.charAt(left);
                charToCount.merge(remC, -1, (a, b) -> a + b);
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
