class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        TreeSet<Integer> reachable = new TreeSet<>();
        reachable.add(0);
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '0') {
                var right = reachable.floor(i - minJump);
                if (right != null && i <= right + maxJump) {
                    reachable.add(i);
                }
                var left = reachable.ceiling(i - maxJump);
                if (left != null && left + minJump <= i) {
                    reachable.add(i);
                }
            }
        }
        return reachable.contains(s.length() - 1);
    }
}