class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if (cLeft != cRight) {
                return checkPalindrome(s, left + 1, right) || 
                       checkPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            if (cLeft != cRight) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
