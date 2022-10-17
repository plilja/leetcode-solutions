class Solution {
    public int largestVariance(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int result = 0;
        for (char c1 = 'a'; c1 <= 'z'; ++c1) {
            for (char c2 = 'a'; c2 <= 'z'; ++c2) {
                int[] c1Counts = new int[s.length()];
                int[] c2Counts = new int[s.length()];
                int[] maxDiffs = new int[s.length()];
                int[] minDiffs = new int[s.length()];
                int left = 0;
                for (int right = 0; right < s.length(); ++right) {
                    char c = s.charAt(right);
                    int c1Delta = 0;
                    int c2Delta = 0;
                    if (c == c1) {
                        c1Delta = 1;
                    } else if (c == c2) {
                        c2Delta = 1;
                    } 
                    if (right == 0) {
                        c1Counts[right] = c1Delta;
                        c2Counts[right] = c2Delta;
                        maxDiffs[right] = Math.max(0, c1Counts[right] - c2Counts[right]);
                        minDiffs[right] = Math.min(0, c1Counts[right] - c2Counts[right]);
                    } else {
                        c1Counts[right] = c1Counts[right - 1] + c1Delta;
                        c2Counts[right] = c2Counts[right - 1] + c2Delta;
                        maxDiffs[right] = Math.max(maxDiffs[right - 1], c1Counts[right] - c2Counts[right]);
                        minDiffs[right] = Math.min(maxDiffs[right - 1], c1Counts[right] - c2Counts[right]);
                    }
                    while (left < right && c1Counts[right] - c1Counts[left] > 0 && c2Counts[right] - c2Counts[left] > 0) {
                        left++;
                    }
                    if (c1Counts[right] > 0 && c2Counts[right] > 0) {
                        if (left == 0) {
                            result = Math.max(result, Math.abs(c1Counts[right] - c2Counts[right]));
                            result = Math.max(result, Math.abs(c1Counts[right] - c2Counts[right]));
                        } else {
                            result = Math.max(result, Math.abs(c1Counts[right] - c2Counts[right] - minDiffs[left - 1]));
                            result = Math.max(result, Math.abs(c1Counts[right] - c2Counts[right] - maxDiffs[left - 1]));
                        }
                    }
                }
            }
        }
        return result;
    }
}
