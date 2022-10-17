class Solution {
    private static final Map<Character, List<Character>> KEYPAD = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < digits.length(); ++i) {
            char digit = digits.charAt(i);
            List<String> newResult = new ArrayList<>();
            for (String combination : result) {
                for (char c : KEYPAD.get(digit)) {
                    newResult.add(combination + c);
                }
            }
            result = newResult;
        }
        return result;
    }
}
