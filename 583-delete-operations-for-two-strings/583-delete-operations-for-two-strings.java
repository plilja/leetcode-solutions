class Solution {
    public int minDistance(String word1, String word2) {
        Map<Pair, Integer> cache = new HashMap<>();
        return helper(word1, word2, 0, 0, cache);
    }

    private int helper(String word1, String word2, int i, int j, Map<Pair, Integer> cache) {
        if (word1.length() == i || word2.length() == j) {
            return word1.length() - i + word2.length() - j;
        }
        Pair cacheKey = new Pair(i, j);
        Integer cached = cache.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        int c1 = word1.charAt(i);
        int c2 = word2.charAt(j);
        if (c1 == c2) {
            return helper(word1, word2, i + 1, j + 1, cache);
        }
        int removeFirst = helper(word1, word2, i + 1, j, cache) + 1;
        int removeSecond = helper(word1, word2, i, j + 1, cache) + 1;
        int result = Math.min(removeFirst, removeSecond);
        cache.put(cacheKey, result);
        return result;
    }

    private record Pair(int left, int right) {
    }
}

