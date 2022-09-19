class Solution {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaceCount++;
            }
        }
        String[] words = text.trim().split(" +");
        int numSpaces; 
        int extraSpaces;
        if (words.length > 1) {
            numSpaces = spaceCount / (words.length - 1);
            extraSpaces = spaceCount - numSpaces * (words.length - 1);
        } else {
            numSpaces = 0;
            extraSpaces = spaceCount;
        }
        StringBuilder result = new StringBuilder();
        result.append(words[0]);
        for (int i = 1; i < words.length; ++i) {
            for (int j = 0; j < numSpaces; ++j) {
                result.append(" ");
            }
            result.append(words[i]);
        }
        for (int j = 0; j < extraSpaces; ++j) {
            result.append(" ");
        }
        return result.toString();
    }
}
