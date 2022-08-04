/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Set<String> words = new HashSet<>();
        for (String word : wordlist) {
            words.add(word);
        }
        for (int i = 0; i < 10; ++i) {
            String nextGuess = words.iterator().next();
            
            int charsCorrect = master.guess(nextGuess);
            if (charsCorrect == 6) {
                return;
            }
            words.remove(nextGuess);
            
            Set<String> notPossible = new HashSet<>();
            for (String word : words) {
                int charsInCommon = calcCharsInCommon(nextGuess, word);
                if (charsInCommon != charsCorrect) {
                    notPossible.add(word);
                }
            }
            words.removeAll(notPossible);
        }
    }
    
    private int calcCharsInCommon(String word1, String word2) {
        int charsInCommon = 0;
        for (int j = 0; j < 6; ++j) {
            if (word1.charAt(j) == word2.charAt(j)) {
                charsInCommon++;
            }
        }
        return charsInCommon;
    }
}
