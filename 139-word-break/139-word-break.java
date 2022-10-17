class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; --i) {
            StringBuilder word = new StringBuilder();
            for (int j = i; j < s.length(); ++j) {
                word.append(s.charAt(j));
                if (wordDict.contains(word.toString()) && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
        return possible[0];
    }
}
