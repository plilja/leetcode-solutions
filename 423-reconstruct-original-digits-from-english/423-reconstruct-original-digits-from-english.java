class Solution {
    private static final Map<Character, Integer> uniqueChars = Map.of(
            'z', 0,
            'w', 2,
            'u', 4,
            'x', 6,
            'g', 8
    );

    private static final Map<Character, Integer> secondOrderUnique = Map.of(
            'f', 5,
            's', 7,
            't', 3
    );

    private static final Map<Character, Integer> thirdOrderUnique = Map.of(
            'i', 9,
            'o', 1
    );

    private static final String[] digits = new String[]{
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    public String originalDigits(String s) {
        int[] balance = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            balance[c - 'a']++;
        }
        List<Integer> reconstructed = new ArrayList<>();
        helper(uniqueChars, balance, reconstructed);
        helper(secondOrderUnique, balance, reconstructed);
        helper(thirdOrderUnique, balance, reconstructed);
        Collections.sort(reconstructed);
        StringBuilder result = new StringBuilder();
        for (int d : reconstructed) {
            result.append(d);
        }
        return result.toString();
    }

    private void helper(Map<Character, Integer> uniqMap, int[] balance, List<Integer> reconstructed) {
        for (var entry : uniqMap.entrySet()) {
            int b = balance[entry.getKey() - 'a'];
            if (b > 0) {
                for (int i = 0; i < b; i++) {
                    reconstructed.add(entry.getValue());
                }
                String digit = digits[entry.getValue()];
                for (int i = 0; i < digit.length(); i++) {
                    char c = digit.charAt(i);
                    balance[c - 'a'] -= b;
                }
            }
        }
    }
}
