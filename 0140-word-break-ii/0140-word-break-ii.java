class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        List<String> result = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), result, words);
        return result;
    }
    
    private void solve(String s, int i, List<String> current, List<String> result, Set<String> words) {
        if (s.length() == i) {
            StringBuilder sb = new StringBuilder(current.get(0));
            for (int j = 1; j < current.size(); ++j) {
                sb.append(" ");
                sb.append(current.get(j));
            }
            result.add(sb.toString());
            return;
        }
        StringBuilder word = new StringBuilder();
        for (int j = i; j < s.length(); ++j) {
            word.append(s.charAt(j));
            if (words.contains(word.toString())) {
                current.add(word.toString());
                solve(s, j + 1, current, result, words);
                current.remove(current.size() - 1);
            }
        }
    }
}