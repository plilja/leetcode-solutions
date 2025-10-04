class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            int childGreed = g[i];
            int cookie = s[j];
            if (childGreed <= cookie) {
                i++;
                result++;
            }
            j++;
        }
        return result;
    }
}

