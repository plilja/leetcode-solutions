class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCharCount = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            tCharCount.merge(t.charAt(i), 1, (a, b) -> a + b);
        }
        boolean possible = false;
        int ansLeft = -1;
        int ansRight = s.length();
        int left = 0;
        int right = 0;
        Set<Character> missing = new HashSet<>(tCharCount.keySet());
        Map<Character, Integer> sCharCount = new HashMap<>();
        while (right < s.length()) {
            while (right < s.length()) {
                char c = s.charAt(right);
                int newCount = sCharCount.merge(c, 1, (a, b) -> a + b);
                int neededCount = tCharCount.getOrDefault(c, 0);
                right++;
                if (newCount == neededCount) {
                    missing.remove(c);
                    if (missing.isEmpty()) {
                        break;
                    }
                }
            }
            if (!missing.isEmpty()) {
                break;
            }
            if ((ansRight - ansLeft) > (right - left - 1)) { 
                ansLeft = left;
                ansRight = right - 1;
                possible = true;
            }
            while (left < right) {
                char c = s.charAt(left);
                int newCount = sCharCount.merge(c, -1, (a, b) -> a + b);
                int neededCount = tCharCount.getOrDefault(c, 0);
                left++;
                if (newCount < neededCount) {
                    missing.add(c);
                    break;
                }
                if ((ansRight - ansLeft) > (right - left - 1)) { 
                    ansLeft = left;
                    ansRight = right - 1;
                    possible = true;
                }
            }
        }
        if (possible) {
            return s.substring(ansLeft, ansRight + 1);
        } else {
            return "";
        }
    }
}
