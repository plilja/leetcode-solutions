class Solution {
    public String addBoldTag(String s, String[] words) {
        Map<Integer, Integer> boldRanges = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            int j = 0;
            while (j < s.length()) {
                int idx = s.indexOf(word, j);
                if (idx == -1) {
                    break;
                }
                boldRanges.merge(idx, idx + word.length(), (a, b) -> Math.max(a, b));
                j = idx + 1;
            }
        }
        int boldUntil = -1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            Integer end = boldRanges.get(i);
            if (end != null) {
                if (boldUntil < i) {
                    result.append("<b>");
                }
                boldUntil = Math.max(boldUntil, end);
            }
            if (boldUntil == i) {
                result.append("</b>");
            }
            result.append(s.charAt(i));
        }
        if (boldUntil == s.length()) {
            result.append("</b>");
        }
        return result.toString();
    }
}