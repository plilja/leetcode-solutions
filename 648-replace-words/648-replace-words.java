class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        Set<String> dictionarySet = new HashSet<>(dictionary);
        for (String word : words) {
            StringBuilder root = new StringBuilder();
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                root.append(c);
                if (dictionarySet.contains(root.toString())) {
                    break;
                }
            }
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(root);
        }
        return result.toString();
    }
}

