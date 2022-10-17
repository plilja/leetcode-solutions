class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNines = true;
        for (int n : digits) {
            if (n != 9) {
                allNines = false;
                break;
            }
        }
        int[] result = new int[allNines ? digits.length + 1 : digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (allNines) {
                result[i + 1] = (digits[i] + carry) % 10;
            } else {
                result[i] = (digits[i] + carry) % 10;
            }
            carry = (digits[i] + carry) / 10;
        }
        if (allNines) {
            result[0] = 1;
        }
        return result;
    }
}
