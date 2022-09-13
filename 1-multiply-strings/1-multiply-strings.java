class Solution {
    public String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            return multiply(num2, num1);
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num1.length(); ++i) {
            int d1 = getDigit(num1, num1.length() - i - 1);
            for (int j = 0; j < num2.length(); ++j) {
                int d2 = getDigit(num2, num2.length() - j - 1);
                int prod = d1 * d2;
                addToResult(result, i + j, prod);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            sb.append(digit);
        }
        sb.reverse();
        return sb.toString();
    }
    
    private int getDigit(String s, int index) {
        return (int) (s.charAt(index) - '0');
    }
    
    private void addToResult(List<Integer> result, int index, int value) {
        while (index >= result.size()) {
            result.add(0);
        }
        int prev = result.get(index);
        int newValue = prev + value;
        result.set(index, newValue % 10);
        if (newValue >= 10) {
            addToResult(result, index + 1, newValue / 10);
        }
    }
}
