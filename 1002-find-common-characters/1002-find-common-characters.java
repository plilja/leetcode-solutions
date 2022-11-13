class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> result = chars(words[0]);
        for (int i = 1; i < words.length; ++i) {
            var cs = chars(words[i]);
            for (char c = 'a'; c <= 'z'; ++c) {
                int a = result.getOrDefault(c, 0);
                int b = cs.getOrDefault(c, 0);
                result.put(c, Math.min(a, b));
            }
        }
        
        return result.entrySet().stream()
            .filter(e -> e.getValue() > 0)
            .flatMap(e -> {
                List<Character> cs = new ArrayList<>();
                for (int i = 0; i < e.getValue(); ++i) {
                    cs.add(e.getKey());
                }
                return cs.stream();
            })
            .map(c -> String.valueOf(c))
            .toList();
    }
    
    private Map<Character, Integer> chars(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            result.merge(c, 1, (a, b) -> a + b);
        }
        return result;
    }
}