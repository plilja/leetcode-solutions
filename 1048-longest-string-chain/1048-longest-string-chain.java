class Solution {
    public int longestStrChain(String[] words) {
        Map<String, List<String>> predecessors = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String wordA = words[i];
            for (int j = 0; j < words.length; ++j) {
                String wordB = words[j];
                if (i != j && isPredecessor(wordA, wordB)) {
                    predecessors.computeIfAbsent(wordB, k -> new ArrayList<>()).add(wordA);
                }
            }
        }
        int result = 0;
        Map<String, Integer> cache = new HashMap<>();
        for (String word : words) {
            int chain = getLongestChain(word, predecessors, cache);
            result = Math.max(result, chain);
        }
        return result;
    }
    
    private int getLongestChain(String word, Map<String, List<String>> predecessors, Map<String, Integer> longestChainCache) {
        var maybeCached = longestChainCache.get(word);
        if (maybeCached != null) {
            return maybeCached;
        }
        
        int result = 0;
        for (String predecessor : predecessors.getOrDefault(word, List.of())) {
            int chainEndingAtPredecessor = getLongestChain(predecessor, predecessors, longestChainCache);
            result = Math.max(result, chainEndingAtPredecessor);
        }
        longestChainCache.put(word, result + 1);
        if (result == 8) {
            System.out.println("foo");
        }
        return result + 1; 
    }
    
    private boolean isPredecessor(String wordA, String wordB) {
        if (wordA.length() + 1 != wordB.length()) {
            return false;
        }
        int nonMatches = 0;
        int i = 0;
        while (i < wordA.length() && nonMatches <= 1) {
            char c1 = wordA.charAt(i);
            char c2 = wordB.charAt(i + nonMatches);
            if (c1 != c2) {
                nonMatches++;
            } else {
                i++;
            }
        }
        return nonMatches <= 1;
    }
}
