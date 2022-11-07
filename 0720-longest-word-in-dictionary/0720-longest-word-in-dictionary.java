class Solution {
    public String longestWord(String[] words) {
        Trie root = new Trie();
        root.wordEndsHere = "";
        for (String w : words) {
            insert(root, w);
        }
        String result = "";
        Deque<Trie> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Trie trie = q.poll();
            if (trie.wordEndsHere == null) {
                continue;
            }
            boolean longer = trie.wordEndsHere.length() > result.length();
            boolean sameLengthAndBefore = trie.wordEndsHere.length() == result.length() &&
                                           trie.wordEndsHere.compareTo(result) < 0; 
            if (longer || sameLengthAndBefore) {
                result = trie.wordEndsHere;
            }
            for (Trie child : trie.children.values()) {
                q.add(child);
            }
        }
        return result;
    }
    
    private void insert(Trie root, String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            current = current.children.computeIfAbsent(c, k -> new Trie());
        }
        current.wordEndsHere = word;
    }
    
    private class Trie {
        private Map<Character, Trie> children = new HashMap<>();
        private String wordEndsHere = null;
    }
}