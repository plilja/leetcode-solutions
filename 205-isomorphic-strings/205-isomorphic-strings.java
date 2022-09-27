class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> replacements = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            Character r = replacements.get(c1);
            if (r != null && r != c2) {
                return false;
            }
            if (r == null) {
                if (mapped.contains(c2)) {
                    return false;
                }
                replacements.put(c1, c2);
                mapped.add(c2);
            }
        }
        return true;
    }
}