class Solution {
    public int numTeams(int[] rating) {
        Map<Integer, Integer> numLargerPairs = new HashMap<>();
        Map<Integer, Integer> numSmallerPairs = new HashMap<>();
        for (int i = 0; i < rating.length - 1; ++i) {
            int a = rating[i];
            for (int j = i + 1; j < rating.length; ++j) {
                int b = rating[j];
                if (a < b) {
                    numLargerPairs.merge(a, 1, (n1, n2) -> n1 + n2);
                } else {
                    numSmallerPairs.merge(a, 1, (n1, n2) -> n1 + n2);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < rating.length - 1; ++i) {
            int a = rating[i];
            for (int j = i + 1; j < rating.length; ++j) {
                int b = rating[j];
                if (a < b) {
                    result += numLargerPairs.getOrDefault(b, 0);
                } else {
                    result += numSmallerPairs.getOrDefault(b, 0);
                }
            }
        }
        return result;
    }
}
