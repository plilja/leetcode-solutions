class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charsUsed = new HashSet<>();
        int result = 0;
        int seqStart = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (charsUsed.contains(c)) {
                for (int j = seqStart; j < i; ++j) {
                    char c2 = s.charAt(j);
                    charsUsed.remove(c2);
                    if (c2 == c) {
                        seqStart = j + 1;
                        break;
                    }
                }
            }
            charsUsed.add(c);
            result = Math.max(result, i - seqStart + 1);
        }
        return result;
    }
}
