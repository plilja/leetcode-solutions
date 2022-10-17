class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(word, 0, "", result, true);
        return result;
    }
    
    private void helper(String word, int i, String current, List<String> result, boolean numFirstOk) {
        if (word.length() == i) {
            result.add(current);
        } else {
            if (!numFirstOk) {
                helper(word, i + 1, current + word.charAt(i), result, true);
            } else {
                for (int j = i + 1; j <= word.length(); ++j) {
                    int count =  j - i;
                    if (j == word.length()) {
                        helper(word, j, current + count, result, false);
                    } else {
                        helper(word, j, current + count, result, false);
                    }
                }
                helper(word, i + 1, current + word.charAt(i), result, true);
            }
            
        }
    }
}