class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int sumLengths = words[i].length();
            int numWords = 1;
            while (i + numWords < words.length && 
                   sumLengths + words[i + numWords].length() + 1 <= maxWidth) {
                sumLengths += words[i + numWords].length() + 1;
                numWords++;
            }
            if (i + numWords < words.length) {
                String line = leftRightJustified(words, i, i + numWords, maxWidth);
                result.add(line);
            } else {
                String line = leftJustified(words, i, i + numWords, maxWidth);
                result.add(line);
            }
            i += numWords;
        }
        return result;
    }
    
    private String leftRightJustified(String[] words, int start, int end, int maxWidth) {
        if (end - start == 1) {
            return leftJustified(words, start, end, maxWidth);
        }
        List<StringBuilder> wordsAndSpaces = new ArrayList<>();
        int totalLength = 0;
        for (int i = start; i < end; ++i) {
            totalLength += words[i].length();
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            wordsAndSpaces.add(sb);
        }
        while (totalLength < maxWidth) {
            for (int i = 0; i < wordsAndSpaces.size() - 1 && totalLength < maxWidth; ++i) {
                wordsAndSpaces.get(i).append(" ");
                totalLength++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb  : wordsAndSpaces) {
            result.append(sb.toString());
        }
        return result.toString();
    }
    
    private String leftJustified(String[] words, int start, int end, int maxWidth) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (int i = start; i < end; ++i) {
            String word = words[i];
            if (!first) {
                result.append(" ");
            }
            result.append(word);
            first = false;
        }
        while (result.length() < maxWidth) {
            result.append(" ");
        }
        return result.toString();
    }
}
