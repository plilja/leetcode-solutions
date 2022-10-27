class Solution {
    private static final List<String> ALPHABET = List.of(
        ".-", "-...", "-.-.", "-..", ".", "..-.",
        "--.", "....", "..", ".---", "-.-", ".-..",
        "--", "-.", "---", ".--.", "--.-", ".-.",
        "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.." 
    );
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> converted = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                int index = c - 'a';
                String morse = ALPHABET.get(index);
                sb.append(morse);
            }
            converted.add(sb.toString());
        }
        return converted.size();
    }
}