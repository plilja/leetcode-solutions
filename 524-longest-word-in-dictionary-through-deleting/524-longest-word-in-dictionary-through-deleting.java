class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            if (word.length() < result.length()) {
                continue;
            }
            int i1 = 0;
            int i2 = 0;
            while (i1 < s.length() && i2 < word.length() && remaining(s, i1) >= remaining(word, i2)) {
                char c1 = s.charAt(i1);
                char c2 = word.charAt(i2);
                if (c1 == c2) {
                    i1++;
                    i2++;
                } else {
                    i1++;
                }
            }
            if (i2 == word.length()) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private int remaining(String s, int index) {
        return s.length() - index - 1;
    }
}

