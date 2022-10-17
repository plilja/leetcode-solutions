class Solution {
    private static final int MAX = 1000000000;
    
    public boolean reorderedPowerOf2(int n) {
        int pow = 1;
        while (pow < MAX) {
            if (canBeReorderedTo(n, pow)) {
                return true;
            }
            pow *= 2;
        }
        return false;
    }
    
    private boolean canBeReorderedTo(int n, int pow) {
        return getDigitCounts(n).equals(getDigitCounts(pow));
    }
    
    private Map<Character, Integer> getDigitCounts(int n) {
        String s = String.valueOf(n);
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            result.merge(s.charAt(i), 1, (a, b) -> a + b);
        }
        return result;
    }
}
