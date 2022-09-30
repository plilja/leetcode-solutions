class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int minAvailable = 0;
        int maxAvailable = s.length();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'I') {
                result[i] = minAvailable;
                minAvailable++;
            } else {
                result[i] = maxAvailable;
                maxAvailable--;
            }
        }
        result[result.length - 1] = minAvailable;
        return result;
    }
}