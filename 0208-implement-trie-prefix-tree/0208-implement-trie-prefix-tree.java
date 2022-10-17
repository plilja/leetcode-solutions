class Trie {
    private Map<Character, Trie> children = new HashMap<>();
    private boolean wordEndsHere = false;

    public Trie() {
    }
    
    public void insert(String word) {
        insert(word, 0);
    }
    
    private void insert(String word, int start) {
        if (word.length() == start) {
            wordEndsHere = true;
        }
        if (start < word.length()) {
            char c = word.charAt(start);
            children.computeIfAbsent(c, k -> new Trie()).insert(word, start + 1);
        }
    }
    
    public boolean search(String word) {
        return search(word, 0);
    }
    
    private boolean search(String word, int start) {
        if (start == word.length()) {
            return wordEndsHere;
        } else if (start < word.length()) {
            char c = word.charAt(start);
            Trie child = children.get(c);
            if (child != null) {
                return child.search(word, start + 1);
            } 
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }
    
    private boolean startsWith(String word, int start) {
        if (start == word.length()) {
            return true;
        } else if (start < word.length()) {
            char c = word.charAt(start);
            Trie child = children.get(c);
            if (child != null) {
                return child.startsWith(word, start + 1);
            } 
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
