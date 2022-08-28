class WordDictionary {
    private final Map<Character, WordDictionary> children = new HashMap<>();
    private boolean wordEndsHere = false;

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        addWord(word, 0);
    }
    
    private void addWord(String word, int from) {
        if (word.length() == from) {
            wordEndsHere = true;
        } else if (from < word.length()) {
            char c = word.charAt(from);
            children.computeIfAbsent(c, k -> new WordDictionary()).addWord(word, from + 1);
        }
    }
    
    public boolean search(String word) {
        return search(word, 0);
    }
    
    private boolean search(String word, int from) {
        if (from == word.length()) {
            return wordEndsHere;
        } else if (from < word.length()) {
            char c = word.charAt(from);
            if (c == '.') {
                for (var child : children.values()) {
                    if (child.search(word, from + 1)) {
                        return true;
                    }
                }
            } else {
                var child = children.get(word.charAt(from));
                if (child != null) {
                    return child.search(word, from + 1);
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
