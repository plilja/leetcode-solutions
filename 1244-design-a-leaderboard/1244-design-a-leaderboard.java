class Leaderboard {
    private final Map<Integer, Integer> playerToScore = new HashMap<>();
    private final TreeMap<Integer, Set<Integer>> scoreToPlayers = new TreeMap<>((a, b) -> b - a);

    public Leaderboard() {
        
    }
    
    public void addScore(int playerId, int score) {
        int oldScore = playerToScore.getOrDefault(playerId, 0);
        if (oldScore != 0) {
            Set<Integer> players = scoreToPlayers.get(oldScore);
            players.remove(playerId);
            if (players.isEmpty()) {
                scoreToPlayers.remove(oldScore);
            }
        }
        int newScore = oldScore + score;
        playerToScore.put(playerId, newScore);
        scoreToPlayers.computeIfAbsent(newScore, k -> new HashSet<>()).add(playerId);
    }
    
    public int top(int K) {
        int rem = K;
        int result = 0;
        for (var entry : scoreToPlayers.entrySet()) {
            int d = Math.min(rem, entry.getValue().size());
            result += d * entry.getKey();
            rem -= d;
            if (rem == 0) {
                break;
            }
        }
        return result;
    }
    
    public void reset(int playerId) {
        int score = playerToScore.remove(playerId);
        Set<Integer> players = scoreToPlayers.get(score);
        players.remove(playerId);
        if (players.isEmpty()) {
            scoreToPlayers.remove(score);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */