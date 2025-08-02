class Solution {
    public int longestIdealString(String s, int k) {
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char lowerLimit = offsetChar(c, -k);
            char upperLimit = offsetChar(c, k);
            m[c - 'a'] = m[c - 'a'] + 1;
            for (int c2 = lowerLimit; c2 <= upperLimit; c2++) {
                if (c != c2) {
                    m[c - 'a'] = Math.max(m[c - 'a'], m[c2 - 'a'] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = Math.max(result, m[i]);
        }
        return result;
    }

    private char offsetChar(char c, int i) {
        int j = (int) c;
        int newChar = j + i;
        newChar = Math.max(newChar, 'a');
        newChar = Math.min(newChar, 'z');
        return (char) newChar;
    }
}

