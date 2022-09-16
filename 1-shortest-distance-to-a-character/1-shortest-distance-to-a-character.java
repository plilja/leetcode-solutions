class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] distsRight = new int[s.length()];
        int distR = s.length() + 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == c) {
                distR = 0;
            } else {
                distR++;
            }
            distsRight[i] = distR;
        }
        int[] distsLeft = new int[s.length()];
        int distL = s.length() + 1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                distL = 0;
            } else {
                distL++;
            }
            distsLeft[i] = distL;
        }
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            result[i] = Math.min(distsLeft[i], distsRight[i]);
        }
        return result;
    }
}
