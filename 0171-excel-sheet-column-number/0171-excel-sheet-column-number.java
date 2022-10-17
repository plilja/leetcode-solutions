class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int significance = 1;
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            char c = columnTitle.charAt(i);
            result += significance * charToDigit(c);
            significance *= 26;
        }
        return result;
    }
    
    private int charToDigit(char c) {
        return 1 + ((int) (c - 'A'));
    }
}
