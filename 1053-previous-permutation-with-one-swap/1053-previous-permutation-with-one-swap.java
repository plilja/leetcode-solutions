class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            // not possible
            return arr;
        }
        int swapIndex = i + 1;
        for (int j = i + 2; j < arr.length; ++j) {
            if (arr[j] > arr[swapIndex] && arr[i] > arr[j]) {
                swapIndex = j;
            }
        }
        int tmp = arr[swapIndex];
        arr[swapIndex] = arr[i];
        arr[i] = tmp;
        return arr;
    }
}