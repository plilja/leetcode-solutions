class Solution {
    public int minNumberOperations(int[] target) {
        int result = target[0];
        int curr = target[0];
        for (int i = 1; i < target.length; ++i) {
            int prev = target[i - 1];
            int val = target[i];
            if (val <= prev) {
                curr = val;
            } else {
                result += (val - curr);
                curr = val;
            }
        }
        return result;
    }
}