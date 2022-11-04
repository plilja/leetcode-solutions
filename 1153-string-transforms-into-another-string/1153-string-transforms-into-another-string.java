class Solution {
    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        Map<Character, Character> mappings = new HashMap<>();
        Set<Character> s2Chars = new HashSet<>();
        for (int i = 0; i < s1.length(); ++i) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            Character c3 = mappings.get(c1);
            if (c3 != null) {
                if (c2 != c3) {
                    return false;
                }
            } else {
                mappings.put(c1, c2);
                s2Chars.add(c2);
            }
        }
        return s2Chars.size() < 26;
    }
}