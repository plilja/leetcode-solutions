class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Set<Character>> wordToChars = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Set<Character> chars = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                chars.add(c);
            }
            wordToChars.put(i, chars);
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> s1 = wordToChars.get(i);
            for (int j = i + 1; j < words.length; j++) {
                Set<Character> s2 = wordToChars.get(j);
                if (!overlaps(s1, s2)) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
           }
        }
        return result;
    }

    private boolean overlaps(Set<Character> s1, Set<Character> s2) {
        for (char c : s1) {
            if (s2.contains(c)) {
                return true;
            }
        }
        return false;
    }
} 
