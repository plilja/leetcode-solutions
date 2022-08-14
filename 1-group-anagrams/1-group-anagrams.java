class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> letterCount = new HashMap<>();
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                letterCount.merge(c, 1, (a, b) -> a + b);
            }
            groups.computeIfAbsent(letterCount, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
