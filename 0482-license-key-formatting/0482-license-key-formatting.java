class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder reversed = new StringBuilder();
        String[] args = s.split("-");
        for (int i = args.length - 1; i >= 0; --i) {
            String arg = args[i];
            StringBuilder sb = new StringBuilder(arg.toUpperCase());
            sb.reverse();
            reversed.append(sb);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); ++i) {
            if (i != 0 && i != reversed.length() && i % k == 0) {
                result.append('-');
            }
            char c = reversed.charAt(i);
            result.append(c);
        }
        result.reverse();
        return result.toString();
    }
}