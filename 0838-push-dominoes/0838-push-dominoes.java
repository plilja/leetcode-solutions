class Solution {
    public String pushDominoes(String dominoes) {
        char[] result = new char[dominoes.length()];
        int[] fallsAt = new int[dominoes.length()];
        Arrays.fill(fallsAt, Integer.MAX_VALUE);
        Arrays.fill(result, '.');
        for (int i = 0; i < dominoes.length(); ++i) {
            char c = dominoes.charAt(i);
            int delta = 0;
            if (c == 'L') {
                delta = -1;
            } else if (c == 'R') {
                delta = 1;
            } else {
                continue;
            }
            int t = 0;
            for (int j = i; j >= 0 && j < dominoes.length(); j += delta) {
                if (fallsAt[j] < t || (j != i && dominoes.charAt(j) != '.')) {
                    break;
                } else if (fallsAt[j] == t && result[j] != c) {
                    result[j] = '.';
                } else {
                    fallsAt[j] = t;
                    result[j] = c;
                }
                t++;
            }
        }
        return new String(result);
    }
}