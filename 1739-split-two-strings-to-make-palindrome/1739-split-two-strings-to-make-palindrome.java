class Solution {

    public boolean checkPalindromeFormation(String a, String b) {
        return helper(a, b) || helper(b, a);
    }

    private boolean helper(String a, String b) {
        if (a.length() != b.length()) {
            throw new IllegalArgumentException("a and b must be the same length");
        }
        int left = 0;
        int right = a.length() - 1;
        while (left < right) {
            if (a.charAt(left) != b.charAt(right)) {
                return isPalindrome(b, left, right)
                        || isPalindrome(a, left, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
