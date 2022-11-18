
class Solution {
    public String convertToTitle(int columnNumber) {
        return helper(columnNumber - 1);
    }
    
    private String helper(int n) {
        char c = (char) ('A' + (n % 26));
        if (n < 26) {
            return "" + c;
        } else {
            return convertToTitle(n / 26) + c;
        }
    }
}