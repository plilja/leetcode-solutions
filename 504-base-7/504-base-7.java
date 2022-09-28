class Solution {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        } if (num == 0) {
            return "0";
        }else {
            StringBuilder result = new StringBuilder();
            int rem = num;
            while (rem > 0) {
                int d = rem % 7;
                result.append(d);
                rem /= 7;
            }
            result.reverse();
            return result.toString();
        }
        
    }
}