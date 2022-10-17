class Solution {
    public String countAndSay(int n) {
        String current = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder next = new StringBuilder();
            char prevChar = current.charAt(0);
            int charCount = 1;
            for (int j = 1; j < current.length(); ++j) {
                char c = current.charAt(j);
                if (prevChar != c) {
                    next.append(charCount);
                    next.append(prevChar);
                    prevChar = c;
                    charCount = 0;
                }
                charCount++;
            }
            next.append(charCount);
            next.append(prevChar);
            current = next.toString();
        }
        return current;
    }
}