class Solution {
    public int minMovesToMakePalindrome(String s) {
        if (s.length() == 1) {
            return 0;
        }
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            chars.add(s.charAt(i));
        }

        int result = 0;
        while (chars.size() > 1) {
            char c = chars.get(0);
            int j = chars.size() - 1;
            while (chars.get(j) != c) {
                j--;
            }
            if (j == 0) {
                if (s.length() % 2 != 1) {
                    throw new IllegalArgumentException("Odd length expected if one character has odd number of occurences");
                }
                // position 0 must be moved to middle position
                result += chars.size() / 2;
                chars.remove(0);
            } else {
                result += (chars.size() - j - 1);
                chars.remove(j);
                chars.remove(0);
            }
        }
        return result;
    }
}
