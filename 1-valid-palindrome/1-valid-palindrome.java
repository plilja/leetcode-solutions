class Solution {
    public boolean isPalindrome(String s) {
        String sLowered = s.toLowerCase();
        int left = 0;
        int right = sLowered.length() - 1;
        while (left < right) {
            char charLeft = sLowered.charAt(left);
            if (!isAlphaNumeric(charLeft)) {
                left++;
                continue;
            }
            char charRight = sLowered.charAt(right);
            if (!isAlphaNumeric(charRight)) {
                right--;
                continue;
            }
            if (charLeft != charRight) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
