class Solution {
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return helper(word1, word2, 0, 0, cache);
    }

    private int helper(String word1, String word2, int word1Pos, int word2Pos, int[][] cache) {
        if (word1Pos == word1.length()) {
            return word2.length() - word2Pos; // No more chars left in word 1, need to insert everything left from word 2
        }
        if (word2Pos == word2.length()) {
            return word1.length() - word1Pos; // No more chars left in word 2, need to remove everything left from word 1
        }
        if (cache[word1Pos][word2Pos] != -1) {
            return cache[word1Pos][word2Pos];
        }
        if (word1.charAt(word1Pos) == word2.charAt(word2Pos)) {
            return helper(word1, word2, word1Pos + 1, word2Pos + 1, cache);
        }
        int sub1 = 1 + helper(word1, word2, word1Pos + 1, word2Pos, cache); // remove char at word1pos
        int sub2 = 1 + helper(word1, word2, word1Pos, word2Pos + 1, cache); // insert correct char at word1pos
        int sub3 = 1 + helper(word1, word2, word1Pos + 1, word2Pos + 1, cache); // replace char at word1pos
        int result = Math.min(Math.min(sub1, sub2), sub3);
        cache[word1Pos][word2Pos] = result;
        return result;
    }
}

