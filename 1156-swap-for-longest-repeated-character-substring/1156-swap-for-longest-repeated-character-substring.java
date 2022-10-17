class Solution {
    public int maxRepOpt1(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            charCounts.merge(c, 1, (a, b) -> a + b);
        }
        Map<Character, Integer> runningCounts = new HashMap<>();
        int left = -1;
        int result = 0;
        for (int right = 0; right < text.length(); ++right) {
            char c = text.charAt(right);
            runningCounts.merge(c, 1, (a, b) -> a + b);
            while (runningCounts.size() > 2) {
                left++;
                char c2 = text.charAt(left);
                int newCount = runningCounts.merge(c2, -1, (a, b) -> a + b);
                if (newCount == 0) {
                    runningCounts.remove(c2);
                }
            }
            while (true) {
                if (runningCounts.size() < 2) {
                    break;
                }
                List<Character> chars = new ArrayList<>(runningCounts.keySet());
                char c1 = chars.get(0);
                char c2 = chars.get(1);
                if (runningCounts.get(c1) == 1) {
                    break; // can swap away c1
                }
                if (runningCounts.get(c2) == 1) {
                    break; // can swap away c2
                }
                left++;
                char c3 = text.charAt(left);
                int newCount = runningCounts.merge(c3, -1, (a, b) -> a + b);
                if (newCount == 0) {
                    runningCounts.remove(c3);
                }
            }
            List<Character> chars = new ArrayList<>(runningCounts.keySet());
            if (chars.size() == 2) {
                char c1 = chars.get(0);
                char c2 = chars.get(1);
                boolean canSwapC1 = runningCounts.get(c1) == 1 && charCounts.get(c2) > runningCounts.get(c2);
                boolean canSwapC2 = runningCounts.get(c2) == 1 && charCounts.get(c1) > runningCounts.get(c1);
                if (canSwapC1 || canSwapC2) {
                    result = Math.max(result, right - left);
                } else {
                    result = Math.max(result, right - left - 1);
                }
            } else {
                    result = Math.max(result, right - left);
                
            }
        }
        return result;
        
    }
}
