class Solution {
    public String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) {
            return addStrings(num2, num1);
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length(); i++) {
            int num1Digit = num1.charAt(num1.length() - 1 - i) - '0'; 
            int num2Digit = 0;
            if (i < num2.length()) {
                num2Digit = num2.charAt(num2.length() - 1 - i) - '0';
            }
            int num = num1Digit + num2Digit + carry;
            result.append(String.valueOf(num % 10));
            carry = num / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
