class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        Map<Domino, Integer> counts = new HashMap<>();
        for (int[] d : dominoes) {
            Domino domino = makeDomino(d[0], d[1]);
            int count = counts.merge(domino, 1, (a, b) -> a + b);
            result += count - 1;
        }
        return result;
    }
    
    private Domino makeDomino(int a, int b) {
        return new Domino(Math.min(a, b), Math.max(a, b));
    }
    
    private record Domino(int a, int b) {
    }
}