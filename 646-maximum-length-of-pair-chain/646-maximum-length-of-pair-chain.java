class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(p -> p[1]));
        int result = 1;
        int rightEdge = pairs[0][1];
        for (int i = 1; i < pairs.length; ++i) {
            int left = pairs[i][0];
            int right = pairs[i][1];
            if (left > rightEdge) {
                rightEdge = right;
                result++;
            }
        }
        return result;
    }
}

