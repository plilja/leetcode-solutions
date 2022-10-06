class Solution {
    private static String VOWELS = "aeiouAEIOU";
    
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder aas = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            if (i > 0) {
                result.append(" ");
            }
            aas.append("a");
            String word = words[i];
            char c = word.charAt(0);
            if (VOWELS.indexOf(c) == -1) {
                String goatWord = word.substring(1, word.length()) + c + "ma" + aas.toString();
                result.append(goatWord);
            } else {
                String goatWord = word + "ma" + aas.toString();
                result.append(goatWord);
            }
        }
        return result.toString();
    }
}