class Solution {
    public int minSteps(String s, String t) {
        int[] sCounts = getCounts(s);
        int[] tCounts = getCounts(t);
        int result = 0;
        for (int i = 0; i < tCounts.length; ++i) {
            if (tCounts[i] < sCounts[i]) {
                result += sCounts[i] - tCounts[i];
            }
        }
        return result;
    }
    
    private int[] getCounts(String s) {
        int count = (int) ('z' - 'a') + 1;
        int[] result = new int[count];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int idx = (int) (c - 'a');
            result[idx]++;
        }
        return result;
    }
}
