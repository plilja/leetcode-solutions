class Solution {
    public boolean makesquare(int[] sticks) {
        int sum = 0;
        for (int stick : sticks){
            sum += stick;
        }
        if (sum % 4 == 0) {
            boolean[] used = new boolean[sticks.length];
            return backtrack(sticks, used, 0, 0, 4, sum / 4);
        } else {
            return false;
        }
    }
    
    private boolean backtrack(int[] sticks, boolean[] used, int i, int current, int pieces, int target) {
        if (pieces == 0) {
            return true;
        }
        if (current == target) {
            return backtrack(sticks, used, 0, 0, pieces - 1, target);
        } 
        for (int j = i; j < sticks.length; ++j) {
            if (used[j] || current + sticks[j] > target) {
                continue;
            }
            used[j] = true;
            if (backtrack(sticks, used, j + 1, current + sticks[j], pieces, target)) {
                return true;
            }
            used[j] = false;
        }
        return false;
    }
}