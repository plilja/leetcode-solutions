class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            chars.merge(p.charAt(i), 1, (a, b) -> a + b);
        }
        Map<Character, Integer> runningChars = new HashMap<>();
        for (int i = 0; i < Math.min(s.length(), p.length()); ++i) {
            runningChars.merge(s.charAt(i), 1, (a, b) -> a + b);
        }
        List<Integer> result = new ArrayList<>();
        if (runningChars.equals(chars)) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); ++i) {
            runningChars.merge(s.charAt(i), 1, (a, b) -> a + b);
            int c = runningChars.merge(s.charAt(i - p.length()), -1, (a, b) -> a + b);
            if (c == 0) {
                runningChars.remove(s.charAt(i - p.length()));
            }
            if (runningChars.equals(chars)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}