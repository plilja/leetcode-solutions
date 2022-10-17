class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            int sum = 0;
            int current = num;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }
            return addDigits(sum);
        }
        
    }
}
