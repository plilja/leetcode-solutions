class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int y = 0;
        int x = 0;
        int sentencePointer = 0;
        int result = 0;
        int clubbedLength = 0;
        int oneFullSentenceLength = 0;
        int clubbedCount = 0;
        for (int i = 0; i < sentence.length; ++i) {
            String s = sentence[i];
            if (i == 0) {
                oneFullSentenceLength += s.length();
            } else {
                oneFullSentenceLength += s.length() + 1;
            }
        }
        while (clubbedLength + oneFullSentenceLength + 20 < cols) {
            if (clubbedLength == 0) {
                clubbedLength += oneFullSentenceLength;
            } else {
                clubbedLength += oneFullSentenceLength + 1;
            }
            clubbedCount++;
        }
        while (y < rows) {
            String word = sentence[sentencePointer];
            if (word.length() > cols) {
                return 0;
            }
            if (x > 0) {
                x++; // add space
            }
            if (clubbedCount > 0 && x + clubbedLength < cols) {
                x += clubbedLength;
                result += clubbedCount;
                x++;
            }
            x += word.length();
            if (x > cols) {
                y += 1;
                x = 0;
            } else {
                sentencePointer++;
                if (sentencePointer == sentence.length) {
                    result++;
                    sentencePointer = 0;
                }
            }
        }
        return result;
    }
}
