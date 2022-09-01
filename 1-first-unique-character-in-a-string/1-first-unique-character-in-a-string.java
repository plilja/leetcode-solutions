class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            count.merge(c, 1, (a, b) -> a + b);
        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (count.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
