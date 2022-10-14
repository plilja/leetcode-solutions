class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] reachable = new boolean[s.length()];
        int left = 0;
        reachable[0] = true;
        for (int i = minJump; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '0') {
                while (left + maxJump < i) {
                    left++;
                    while (left < s.length() && !reachable[left]) {
                        left++;
                    }
                }
                if (left + minJump <= i && left + maxJump >= i) {
                    reachable[i] = true;
                }
            }
        }
        return reachable[s.length() - 1];
    }
}