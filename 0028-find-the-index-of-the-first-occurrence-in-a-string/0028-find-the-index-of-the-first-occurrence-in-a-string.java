class Solution {
    public int strStr(String haystack, String needle) {
        int[] pattern = makePattern(needle);
        return matchesPattern(haystack, needle, pattern);
    }

    private int[] makePattern(String needle) {
        int[] pattern = new int[needle.length()];
        Arrays.fill(pattern, -1);
        int i = 1;
        int j = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }

    private int matchesPattern(String haystack, String needle, int[] pattern) {
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (needle.length() == j) {
                    return i - needle.length();
                }
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return -1;
    }
}
