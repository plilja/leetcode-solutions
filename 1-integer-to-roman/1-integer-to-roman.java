class Solution {
    
    public String intToRoman(int num) {
        if (num >= 1000) {
            int count = num / 1000;
            return repeat('M', count) + intToRomanIfNotZero(num % 1000);
        } else if (num >= 900) {
            return "CM" + intToRomanIfNotZero(num - 900);
        } else if (num >= 500) {
            return "D" + intToRomanIfNotZero(num - 500);
        } else if (num >= 400) {
            return "CD" + intToRomanIfNotZero(num - 400);
        } else if (num >= 100) {
            int count = num / 100;
            return repeat('C', count) + intToRomanIfNotZero(num % 100);
        } else if (num >= 90) {
            return "XC" + intToRomanIfNotZero(num - 90);
        } else if (num >= 50) {
            return "L" + intToRomanIfNotZero(num - 50);
        } else if (num >= 40) {
            return "XL" + intToRomanIfNotZero(num - 40);
        } else if (num >= 10) {
            int count = num / 10;
            return repeat('X', count) + intToRomanIfNotZero(num % 10);
        } else if (num == 9) {
            return "IX";
        } else if (num >= 5) {
            return "V" + intToRomanIfNotZero(num - 5);
        } else if (num == 4) {
            return "IV";
        } else {
            return repeat('I', num);
        }
    }
    
    private String repeat(char c, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            result.append(c);
        }
        return result.toString();
    }
    
    private String intToRomanIfNotZero(int num) {
        if (num == 0) {
            return "";
        } else {
            return intToRoman(num);
        }
    }
}
