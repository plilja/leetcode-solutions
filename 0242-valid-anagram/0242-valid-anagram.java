class Solution {
    public boolean isAnagram(String s, String t) {
        var mapS = getCharacterCount(s);
        var mapT = getCharacterCount(t);
        return mapS.equals(mapT);
    }
    
    private Map<Character, Integer> getCharacterCount(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            result.merge(c, 1, (a, b) -> a + b);
        }
        return result;
    }
}
