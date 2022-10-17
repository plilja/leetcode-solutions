class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int result = 0;
        Map<Character, Integer> counts = new HashMap<>();
        int left = -1;
        for (int i = 0; i < s.length(); ++i) {
            counts.merge(s.charAt(i), 1, (a, b) -> a + b);
            while (counts.size() > k) {
                left++;
                int newCount = counts.merge(s.charAt(left), -1, (a, b) -> a + b);
                if (newCount == 0) {
                    counts.remove(s.charAt(left));
                }
            }
            result = Math.max(result, i - left);
        }
        return result;
    }
}