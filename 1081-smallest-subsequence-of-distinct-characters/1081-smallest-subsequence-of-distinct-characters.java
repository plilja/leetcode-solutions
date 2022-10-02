class Solution {
    public String smallestSubsequence(String s) {
        if (s.isEmpty()) {
            return "";
        }
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            chars.add(c);
        }
        int j = s.length() - 1;
        while (j >= 0) {
            char c = s.charAt(j);
            chars.remove(c);
            if (chars.isEmpty()) {
                break;
            }
            j--;
        }
        char charToRemove = s.charAt(j);
        int removeAtIndex = j;
        while (j >= 0) {
            char c = s.charAt(j);
            if (c <= charToRemove) {
                charToRemove = c;
                removeAtIndex = j;
            }
            j--;
        }
        String remainder = s.substring(removeAtIndex).replaceAll("" + charToRemove, "");
        return charToRemove + smallestSubsequence(remainder);
    }
}