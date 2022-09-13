class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i = 0;
        while (i < arr.length) {
            boolean match = false;
            for (int[] piece : pieces) {
                int j = -1;
                while (j + 1 < piece.length && 
                       i + j + 1 < arr.length &&
                       piece[j + 1] == arr[i + j + 1]) {
                    j++;
                }
                if (j == piece.length - 1) {
                    i += piece.length;
                    match = true;
                    break;
                }
            }
            if (!match) {
                return false;
            }
        }
        return i == arr.length;
    }
}
