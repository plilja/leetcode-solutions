class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            int j = 0;
            while (i - j - 1 >= 0 && 
                   i + j + 1 < s.length()  &&
                   s.charAt(i - j - 1) == s.charAt(i + j + 1)) {
                j++;
            }
            result += j + 1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                j = 0;
                while (i - j - 1 >= 0 && 
                       i + j + 2 < s.length()  &&
                       s.charAt(i - j - 1) == s.charAt(i + j + 2)) {
                    j++;
                }
                result += j + 1;
            }
        }
        return result;
    }
}
