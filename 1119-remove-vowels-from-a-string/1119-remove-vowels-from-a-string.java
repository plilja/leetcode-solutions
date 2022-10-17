class Solution {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    
    public String removeVowels(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!vowels.contains(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
