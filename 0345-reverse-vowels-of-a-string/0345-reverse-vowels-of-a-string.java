class Solution {
    private static final String vowels = "aeiouAEIOU";
        
    public String reverseVowels(String s) {
        ArrayList<Integer> vowelIndexes = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) != -1) {
                vowelIndexes.add(i);
            }
        }
        StringBuilder result = new StringBuilder();
        int nextVowel = vowelIndexes.size() - 1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) != -1) {
                char v = s.charAt(vowelIndexes.get(nextVowel));
                result.append(v);
                nextVowel--;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}