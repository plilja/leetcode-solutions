class Solution {
    public int minCost(String colors, int[] neededTime) {
        char prev = '?';
        int result = 0;
        int maxInGroup = Integer.MIN_VALUE;
        for (int i = 0; i < colors.length(); ++i) {
            char c = colors.charAt(i);
            int time = neededTime[i];
            if (c != prev) {
                maxInGroup = time;
            } else {
                if (time > maxInGroup) {
                    result += maxInGroup;
                    maxInGroup = time;
                } else {
                    result += time;
                }
            }
            prev = c;
        }
        return result;
    }
}