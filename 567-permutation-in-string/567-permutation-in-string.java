class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> countsS1 = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);
            countsS1.merge(c, 1, (a, b) -> a + b);
        }
        Map<Character, Integer> countsS2 = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            countsS2.merge(c, 1, (a, b) -> a + b);
            while (true) {
                boolean leftNeedsToMove = false;
                for (char c3 = 'a'; c3 <= 'z' && !leftNeedsToMove; ++c3) {
                    if (countsS1.getOrDefault(c3, 0) < countsS2.getOrDefault(c3, 0)) {
                        leftNeedsToMove = true;
                    }
                }
                if (!leftNeedsToMove) {
                    break;
                }
                char c2 = s2.charAt(left);
                int newCount = countsS2.merge(c2, -1, (a, b) -> a + b);
                if (newCount == 0){
                    countsS2.remove(c2);
                }
                left++;
            }
            if (countsS1.equals(countsS2)) {
                return true;
            }
        }
        return false;
    }
}
