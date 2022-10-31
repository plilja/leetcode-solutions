class Solution {
    public int compress(char[] chars) {
        int store = 0;
        char prev = chars[0];
        int count = 1;
        for (int i = 1; i <= chars.length; ++i) {
            if (i == chars.length || chars[i] != prev) {
                if (count == 1) {
                    chars[store] = prev;
                    store++;
                } else {
                    chars[store] = prev;
                    store++;
                    String sCount = String.valueOf(count);
                    for (int j = 0; j < sCount.length(); ++j) {
                        char d = sCount.charAt(j);
                        chars[store] = d;
                        store++;
                    }
                }
                count = 0;
            }
            if (i < chars.length) {
                prev = chars[i];
            }
            count++;
        }
        return store;
    }
}