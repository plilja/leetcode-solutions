class Solution {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            return addBinary(b, a);
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < a.length(); ++i) {
            int sum = carry;
            if (a.charAt(a.length() - 1 - i) == '1') {
                sum++;
            }
            if (i < b.length() && b.charAt(b.length() - 1 - i) == '1') {
                sum++;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    }
}