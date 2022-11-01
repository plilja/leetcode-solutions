class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < scores.length; ++i) {
            players.add(new Player(scores[i], ages[i]));
        }
        players.sort((p1, p2) -> {
            if (p1.age != p2.age) {
                return p1.age - p2.age;
            } else {
                return p1.score - p2.score;
            }
        });
        // dp[i] == best score we can get considering
        // players 0 to i and player i must be in the team
        int[] dp = new int[players.size()];
        for (int i = 0; i < players.size(); ++i) {
            Player p = players.get(i);
            dp[i] = p.score;
            for (int j = i - 1; j >= 0; --j) {
                Player p2 = players.get(j);
                if (p2.score <= p.score) {
                    dp[i] = Math.max(dp[i], dp[j] + p.score);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < players.size(); ++i) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    
    private record Player(int score, int age) {
    }
}