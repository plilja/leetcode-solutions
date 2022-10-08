class Solution {
    public String rankTeams(String[] votes) {
        int m = votes[0].length();
        Map<Character, Team> teams = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); ++i) {
                char c = vote.charAt(i);
                Team team = teams.computeIfAbsent(c, k -> new Team(k, new int[m]));
                team.votes[i]++;
            }
        }
        return teams.values().stream()
            .sorted()
            .map(t -> String.valueOf(t.name()))
            .reduce("", (a, b) -> a + b);
    }
    
    record Team(char name, int[] votes) implements Comparable<Team> {
        @Override
        public int compareTo(Team other) {
            for (int i = 0; i < Math.min(votes.length, other.votes.length); ++i) {
                if (votes[i] != other.votes[i]) {
                    return other.votes[i] - votes[i];
                }
            }
            return name - other.name;
        }
    }
}