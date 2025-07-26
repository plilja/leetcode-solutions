class Solution {
    public int maximumSwap(int num) {
        int result = num;
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                swap(arr, i, j);
                result = Math.max(result, Integer.parseInt(String.valueOf(arr)));
                swap(arr, i, j);
            }
        }
        return result;
    }

    private void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

