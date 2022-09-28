class Solution {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        } else {
            int b = 1;
            while (b * 7 <= num) {
                b *= 7;
            }
            StringBuilder result = new StringBuilder();
            int rem = num;
            while (b >= 1) {
                int d = rem / b;
                result.append(d);
                rem -= d * b;
                b /= 7;
            }
            return result.toString();
        }
    }
}