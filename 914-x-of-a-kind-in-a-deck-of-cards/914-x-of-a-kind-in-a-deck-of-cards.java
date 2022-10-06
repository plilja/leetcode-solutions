class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int card : deck) {
            counts.merge(card, 1, (a, b) -> a + b);
        }
        Integer size = null;
        for (int v: counts.values()) {
            if (size == null) {
                size = v;
            }
            size = gcd(v, size);
            if (size == 1) {
                return false;
            }
        }
        return true;
    }
    
    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}