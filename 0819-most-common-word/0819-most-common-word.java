class Solution {
    public String mostCommonWord(String paragraph, String[] bannedArr) {
        Set<String> banned = new HashSet<>();
        for (String w : bannedArr) {
            banned.add(w.toLowerCase());
        }
        Map<String, Integer> counts = new HashMap<>();
        String[] words = paragraph.split("[!?',;\\. ]");
        for (String w : words) {
            String wAdj = w.strip().toLowerCase();
            if (!banned.contains(wAdj) && !wAdj.isEmpty()) {
                counts.merge(wAdj, 1, (a, b) -> a + b);
            }
        }
        int mostCommon = 0;
        String result = "";
        for (var entry : counts.entrySet()) {
            if (entry.getValue() > mostCommon) {
                result = entry.getKey();
                mostCommon = entry.getValue();
            }
        }
        return result;
    }
}