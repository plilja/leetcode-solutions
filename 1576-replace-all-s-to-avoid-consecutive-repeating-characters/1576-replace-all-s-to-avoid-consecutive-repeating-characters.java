class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '?') {
                char prev = 'a';
                char next = 'a';
                if (sb.length() > 0) {
                    prev = sb.charAt(sb.length() - 1);
                }
                if (i < s.length() - 1) {
                    next = s.charAt(i + 1);
                }
                for (char replacement : List.of('a', 'b', 'c')) {
                    if (replacement != prev && replacement != next) {
                        sb.append(replacement);
                        break;
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
