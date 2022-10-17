class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int result = 0;
        int left = -1;
        for (int right = 0; right < s.length(); ++right) {
            chars.merge(s.charAt(right), 1, (a, b) -> a + b);
            while (chars.size() > 2) {
                left++;
                int newCount = chars.merge(s.charAt(left), -1, (a, b) -> a + b);
                if (newCount == 0) {
                    chars.remove(s.charAt(left));
                }
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}