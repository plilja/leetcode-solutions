class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < tiles.length(); ++i) {
            char c = tiles.charAt(i);
            counts.merge(c, 1, (a, b) -> a + b);
        }
        return solve(counts);
    }
    
    private int solve(Map<Character, Integer> counts) {
        List<Character> keys = new ArrayList<>(counts.keySet());
        int result = 0;
        for (char c : keys) {
            int count = counts.merge(c, -1, (a, b) -> a + b);
            if (count == 0) {
                counts.remove(c);
            }
            result++;
            result += solve(counts);
            counts.merge(c, 1, (a, b) -> a + b);
        }
        return result;
    }
    
}