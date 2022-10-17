class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }
        for (int i = arr.length - 1; i >= 0; --i) {
            if (arr[i] == 0) {
                zeroCount--;
            }
            if (i + zeroCount < arr.length) {
                arr[i + zeroCount] = arr[i];
            }
            if (arr[i] == 0 && i + zeroCount + 1 < arr.length) {
                arr[i + zeroCount + 1] = arr[i];
            }
        }
        
    }
}
