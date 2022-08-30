class Solution {
    public int countBinarySubstrings(String s) {
        int prevCount = 0;
        int currCount = 1;
        char currChar = s.charAt(0);
        int result = 0;
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != currChar) {
                result += Math.min(prevCount, currCount);
                prevCount = currCount;
                currCount = 1;
                currChar = c;
            } else {
                currCount++;
            }
        }
        result += Math.min(prevCount, currCount);
        return result;
    }
}
