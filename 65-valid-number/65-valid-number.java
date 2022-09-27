class Solution {
    public boolean isNumber(String s) {
        return validInteger(s) || 
               validDecimal(s) || 
               validScientific(s);
    }
    
    private boolean validInteger(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return validInteger(s.substring(1));
        }
        return onlyDigits(s);
    }
    
    private boolean onlyDigits(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    private boolean validDecimal(String s) {
        if (s.length() <= 1) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return validDecimal(s.substring(1));
        }
        int i = s.indexOf('.');
        if (i == -1) {
            return false;
        }
        String num = s.substring(0, i);
        String decimals = s.substring(i + 1);
        return (num.length() == 0 || onlyDigits(num)) &&
               (decimals.length() == 0 || onlyDigits(decimals));
    }
    
    private boolean validScientific(String s) {
        int i = s.indexOf('e');
        if (i == -1) {
            i = s.indexOf('E');
        }
        if (i == -1) {
            return false;
        }
        String num = s.substring(0, i);
        String exp = s.substring(i + 1);
        return (validDecimal(num) && validInteger(exp)) ||
               (validInteger(num) && validInteger(exp));
    }
    
    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
}