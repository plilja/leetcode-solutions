class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        for (String word : s.split(" ")) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(sb);
        }
        return result.toString();
    }
}