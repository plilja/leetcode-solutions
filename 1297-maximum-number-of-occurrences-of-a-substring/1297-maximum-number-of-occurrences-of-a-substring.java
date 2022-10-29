class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Set<Character> chars = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + maxSize && j < s.length(); ++j) {
                char c = s.charAt(j);
                chars.add(c);
                if (chars.size() > maxLetters) {
                    break;
                }
                sb.append(c);
                if (sb.length() >= minSize) {
                    counts.merge(sb.toString(), 1, (a, b) -> a + b);
                }
            }
        }
        int largest = 0;
        for (var entry : counts.entrySet()) {
            largest = Math.max(largest, entry.getValue());
        }
        return largest;
    }
}