class Solution {
    public long appealSum(String s) {
        long[] countLeft = getCountLeft(s);
        long result = 0;
        for (int i = 0; i < s.length(); ++i) {
            result += countLeft[i] * (s.length() - i);
        }
        return result;
    }
    
    private long[] getCountLeft(String s) {
        Map<Character, Integer> maxIndex = new HashMap<>();
        long[] result = new long[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int closestIndex = maxIndex.getOrDefault(c, -1);
            result[i] = i - closestIndex;
            maxIndex.put(c, i);
        }
        return result;
    }
}
