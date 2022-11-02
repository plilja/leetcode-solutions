class Solution {
    private static final String[] keyboard = new String[] {
        "ABCDEF",
        "GHIJKL",
        "MNOPQR",
        "STUVWX",
        "YZ"
    };

    public int minimumDistance(String word) {
        int[][] dist = new int[27][27];
        for (int y1 = 0; y1 < keyboard.length; ++y1) {
            for (int x1 = 0; x1 < keyboard[y1].length(); ++x1) {
                for (int y2 = 0; y2 < keyboard.length; ++y2) {
                    for (int x2 = 0; x2 < keyboard[y2].length(); ++x2) {
                        int d = Math.abs(y1 - y2) + Math.abs(x1 - x2);
                        char c1 = keyboard[y1].charAt(x1);
                        char c2 = keyboard[y2].charAt(x2);
                        dist[c1 - 'A'][c2 - 'A'] = d;
                    }
                }
            }
        }
        // dp[i][thumb1][thumb2] -> best solution from i to end of word
        int[][][] dp = new int[word.length() + 1][27][27];
        int result = Integer.MAX_VALUE;
        for (int i = word.length() - 1; i >= 0; --i) {
            char c = word.charAt(i);
            for (char thumb1 = 'A'; thumb1 <= 'Z'; ++thumb1) {
                for (char thumb2 = 'A'; thumb2 <= 'Z'; ++thumb2) {
                    int dist1 = dist[thumb1 - 'A'][c - 'A'];
                    int dist2 = dist[thumb2 - 'A'][c - 'A'];
                    dp[i][thumb1 - 'A'][thumb2 - 'A'] = Math.min(
                        dist1 + dp[i + 1][c - 'A'][thumb2 - 'A'], 
                        dist2 + dp[i + 1][thumb1 - 'A'][c - 'A']
                    );
                    if (i == 0) {
                        result = Math.min(result, dp[i][thumb1 - 'A'][thumb2 - 'A']);
                    }
                }
            }
        }
        return result;
    }
}