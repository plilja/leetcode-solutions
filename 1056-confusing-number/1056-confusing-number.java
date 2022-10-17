class Solution {
    private static final Map<Integer, Integer> MAPPING = Map.of(
        0, 0,
        1, 1,
        6, 9,
        8, 8,
        9, 6
    );
    private static final Set<Integer> NON_VALID = Set.of(
        2,
        3,
        4,
        5,
        7
    );
    
    public boolean confusingNumber(int n) {
        StringBuilder sb = new StringBuilder();
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); ++i) {
            char c = nStr.charAt(i);
            int k = Integer.parseInt("" + c);
            if (NON_VALID.contains(k)) {
                return false;
            }
            sb.append(MAPPING.get(k));
        }
        sb.reverse();
        return !sb.toString().equals(nStr);
    }
}
