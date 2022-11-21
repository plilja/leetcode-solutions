class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int a = 0;
        int b = arr.length - 1;
        while (a < b) {
            int middle = (a + b) / 2;
            if (arr[middle] < arr[middle + 1]) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a;
    }
}