class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; ++i) {
            int swapsToTop = 0;
            int swapsToBottom = 0;
            boolean possible = true;
            for (int j = 0; j < tops.length; ++j) {
                if (tops[j] != i && bottoms[j] != i) {
                    possible = false;
                    break;
                }
                if (tops[j] == i && bottoms[j] != i) {
                    swapsToBottom++;
                }
                if (bottoms[j] == i && tops[j] != i) {
                    swapsToTop++;
                }
            }
            if (possible) {
                result = Math.min(result, swapsToTop);
                result = Math.min(result, swapsToBottom);
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}
