class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (true) {
            if (strs[0].length() == i) {
                break;
            }
            boolean match = true;
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.length() == i) {
                    match = false;
                    break;
                }
                char c2 = str.charAt(i);
                if (c != c2) {
                    match = false;
                }
            }
            if (!match) {
                break;
            }
            i++;
            result.append(c);
        }
        return result.toString();
    }
}
