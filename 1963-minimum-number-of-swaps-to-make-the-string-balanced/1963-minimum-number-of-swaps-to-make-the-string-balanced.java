class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int minBalance = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }
            minBalance = Math.min(minBalance, balance);
        }
        return (int) Math.ceil(Math.abs(minBalance) / 2D);
    }
}