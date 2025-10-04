class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                totalOnes++;
            }
        }
        int zeros = 0;
        int ones = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeros++;
            } else {
                ones++;
            }
            int score = zeros + totalOnes - ones;
            result = Math.max(result, score);
        }
        return result;
    }
}

