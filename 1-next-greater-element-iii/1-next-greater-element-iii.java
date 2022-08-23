class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int moveLeftIdx = -1;
        for (int j = i + 1; j < arr.length; ++j) {
            if (arr[j] > arr[i]) {
                if (moveLeftIdx == -1 || arr[moveLeftIdx] > arr[j]) {
                    moveLeftIdx = j;
                } 
            }
        }
        swap(arr, i, moveLeftIdx);
        Arrays.sort(arr, i + 1, arr.length);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; ++j) {
            sb.append(arr[j]);
        }
        long result = Long.parseLong(sb.toString());
        if (result > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) result;
        }
    }
    
    private void swap(char[] arr, int a, int b) {
        char aTmp = arr[a];
        arr[a] = arr[b];
        arr[b] = aTmp;
    }
}
