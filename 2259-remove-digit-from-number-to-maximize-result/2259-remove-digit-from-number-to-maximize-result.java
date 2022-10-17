class Solution {
    public String removeDigit(String number, char digit) {
        Integer removeAt = null;
        Character rightOf = null;
        for (int i = number.length() - 1; i >= 0; --i) {
            char c = number.charAt(i);
            if (c == digit) {
                if (removeAt == null) {
                    removeAt = i;
                } else if (rightOf != null && rightOf > digit) {
                    removeAt = i;
                }
            } else {
                rightOf = c;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            if (i != removeAt) {
                result.append(number.charAt(i));
            }
        }
        return result.toString();
    }
}
