class Solution {
    
    public int hIndex(int[] citations) {
        TreeMap<Integer, Integer> citationsSorted = new TreeMap<>((a, b) -> b - a);
        for (int citation : citations) {
            citationsSorted.merge(citation, 1, (a, b) -> a + b);
        }
        int n = citations.length;
        int countSeen = 0;
        int prev = 1000;
        for (var entry : citationsSorted.entrySet()) {
            int citation = entry.getKey();
            for (int h = prev; h > citation; --h) {
                if (countSeen >= h) {
                    return h;
                }
            }
            int count = entry.getValue();
            countSeen += count;
            if (countSeen >= citation) {
                return citation;
            }
            prev = citation;
        }
        return n;
        
    }
}
