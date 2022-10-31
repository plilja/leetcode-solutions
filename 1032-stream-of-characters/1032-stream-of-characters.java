class StreamChecker {
    private final LinkedList<Trie> queries = new LinkedList<>();
    private final Trie root = new Trie();

    public StreamChecker(String[] words) {
        for (String word : words) {
            insertWord(word);
        }
    }
    
    public boolean query(char letter) {
        queries.add(root);
        ListIterator<Trie> it = queries.listIterator(0);
        boolean result = false;
        while (it.hasNext()) {
            Trie query = it.next();
            Trie maybeNext = query.children.get(letter);
            if (maybeNext != null) {
                it.set(maybeNext);
                if (maybeNext.wordEndsHere) {
                    result = true;
                }
            } else {
                it.remove();
            }
        }
        return result;
    }
    
    private void insertWord(String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            current = current.children.computeIfAbsent(c, k -> new Trie());
        }
        current.wordEndsHere = true;
    }
    
    private class Trie {
        private final Map<Character, Trie> children = new HashMap<>();
        private boolean wordEndsHere;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */