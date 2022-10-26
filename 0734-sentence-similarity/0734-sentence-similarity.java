class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> similar = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String a = pair.get(0);
            String b = pair.get(1);
            similar.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            similar.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        for (int i = 0; i < sentence1.length; ++i) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if (!w1.equals(w2) && !similar.getOrDefault(w1, Set.of()).contains(w2)) {
                return false;
            }
        }
        return true;
    }
}