class Solution {
    public String reverseOnlyLetters(String s) {
        List<Integer> letterIndexes = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                letterIndexes.add(i);
            }
        }
        int nextLetterIndex = letterIndexes.size() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                result.append(s.charAt(letterIndexes.get(nextLetterIndex)));
                nextLetterIndex--;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}