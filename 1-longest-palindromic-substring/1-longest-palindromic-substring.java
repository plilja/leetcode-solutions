class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            int j = 0;
            while (i - j >= 0 && i + j < s.length()) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    j++;
                } else {
                    break;
                }
            }
            j--;
            if (1 + 2 * j > result.length()) {
                result = s.substring(i - j, i + j + 1);
            }
            j = 0;
            while (i - j >= 0 && i + j  + 1 < s.length()) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    j++;
                } else {
                    break;
                }
            }
            j--;
            if (2 * (j + 1) > result.length()) {
                result = s.substring(i - j, i + j + 2);
            }
        }
        return result;
    }
}
