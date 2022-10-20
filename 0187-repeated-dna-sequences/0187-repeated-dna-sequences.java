class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seqs = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 10; i <= s.length(); ++i) {
            String seq = s.substring(i - 10, i);
            if (seqs.contains(seq)) {
                result.add(seq);
            } else {
                seqs.add(seq);
            }
        }
        return new ArrayList<>(result);
    }
}