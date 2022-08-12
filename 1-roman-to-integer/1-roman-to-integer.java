class Solution {
    Map<Character, Integer> SYMBOL_TO_VALUE = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    Map<Character, Set<Character>> VALID_SUBTRACT = Map.of(
        'I', Set.of('V', 'X'),
        'X', Set.of('L', 'C'),
        'C', Set.of('D', 'M')
    );
    
    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int sign = 1;
            char c = s.charAt(i);
            var validNextCharSubtract = VALID_SUBTRACT.getOrDefault(c, Set.of());
            if (i < n - 1 && validNextCharSubtract.contains(s.charAt(i + 1))) {
                sign = -1;
            }
            result += sign * SYMBOL_TO_VALUE.get(c);
        }
        return result;
    }
}
