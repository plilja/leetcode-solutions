class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder recreated = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            if (c >= '0' && c <= '9') {
                number.append(c);
            } else {
                if (number.length() > 0 && number.charAt(0) == '0') {
                    return false;
                }
                appendWildcards(recreated, number, word.length() + 1);
                recreated.append(c);
            }
        }
        if (number.length() > 0 && number.charAt(0) == '0') {
            return false;
        }
        appendWildcards(recreated, number, word.length() + 1);
        if (word.length() != recreated.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) != recreated.charAt(i) && recreated.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    
    private void appendWildcards(StringBuilder recreated, StringBuilder number, int max) {
        if (number.length() > 0) {
            int n = Integer.parseInt(number.toString());
            for (int j = 0; j < Math.min(n, max); ++j) {
                recreated.append('*');
            }
            number.setLength(0);
        }
    }
}
