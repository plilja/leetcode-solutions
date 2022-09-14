class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>();
        Set<String> alreadyMapped = new HashSet<>();
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            String word = words[i];
            String previousMapping = charToWord.get(c);
            if (previousMapping == null) {
                if (alreadyMapped.contains(word)) {
                    return false;
                }
                charToWord.put(c, word);
                alreadyMapped.add(word);
            } else if (!word.equals(previousMapping)) {
                return false;
            }
        }
        return true;
    }
}
