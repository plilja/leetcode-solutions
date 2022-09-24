class TopVotedCandidate {
    private TreeMap<Integer, Integer> leaderAtTime = new TreeMap<>();
        
    public TopVotedCandidate(int[] persons, int[] times) {
        int leader = -1;
        int leaderCount = -1;
        Map<Integer, Integer> personToVotes = new HashMap<>();
        for (int i = 0; i < times.length; ++i) {
            int person = persons[i];
            int time = times[i];
            int newCount = personToVotes.merge(person, 1, (a, b) -> a + b);
            if (newCount >= leaderCount) {
                leader = person;
                leaderCount = newCount;
            }
            leaderAtTime.put(time, leader);
        }
    }
    
    public int q(int t) {
        return leaderAtTime.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */