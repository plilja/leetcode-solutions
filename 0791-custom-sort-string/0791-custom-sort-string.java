class Solution {
    public String customSortString(String order, String s) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            chars.add(s.charAt(i));
        }
        chars.sort((a, b) -> {
            if (a == b) {
                return 0;
            }
            int idx1 = order.indexOf(a); 
            int idx2 = order.indexOf(b); 
            return idx1 - idx2;
        });
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(c);
        }
        return result.toString();
    }
}