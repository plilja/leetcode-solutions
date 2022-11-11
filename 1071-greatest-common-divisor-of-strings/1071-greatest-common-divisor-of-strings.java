class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sub1 = new StringBuilder();
        StringBuilder sub2 = new StringBuilder();
        String result = "";
        for (int i = 0; i < Math.min(str1.length(), str2.length()); ++i) {
            sub1.append(str1.charAt(i));
            sub2.append(str2.charAt(i));
            if (!sub1.toString().equals(sub2.toString())) {
                break;
            }
            if (str1.length() % sub1.length() != 0) {
                continue;
            }
            if (str2.length() % sub1.length() != 0) {
                continue;
            }
            boolean divides = true;
            for (int j = 0; j < str1.length() && divides; ++j) {
                char c1 = str1.charAt(j);
                char c2 = sub1.charAt(j % sub1.length());
                divides = c1 == c2;
            }
            for (int j = 0; j < str2.length() && divides; ++j) {
                char c1 = str2.charAt(j);
                char c2 = sub1.charAt(j % sub1.length());
                divides = c1 == c2;
            }
            if (divides) {
                result = sub1.toString();
            }
        }
        return result;
    }
}