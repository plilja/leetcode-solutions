class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); ++i) {
            int cost = 0;
            for (int j = 0; j < boxes.length(); ++j) {
                if (boxes.charAt(j) == '1') {
                    cost += Math.abs(i - j);
                }
            }
            result[i] = cost;
        }
        return result;
    }
}
