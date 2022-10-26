class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
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
            if (!w1.equals(w2)) {
                Deque<String> q = new ArrayDeque<>();
                q.add(w1);
                Set<String> visited = new HashSet<>();
                while (!q.isEmpty() && !visited.contains(w2)) {
                    String w = q.pollFirst();
                    if (visited.contains(w)) {
                        continue;
                    }
                    visited.add(w);
                    for (String next : similar.getOrDefault(w, Set.of())) {
                        if (!visited.contains(next)) {
                            q.add(next);
                        }
                    }
                }
                if (!visited.contains(w2)) {
                    return false;
                }
            }
        }
        return true;
    }
}