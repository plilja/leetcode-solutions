class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 1; --i) {
            int max = i;
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            flip(arr, max); // move max to index 0
            result.add(max + 1);
            flip(arr, i); // move max to index i
            result.add(i + 1);
        }
        return result;
    }
    
    private void flip(int[] arr, int k) {
        int left = 0;
        int right = k;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] arr, int a, int b) {
        int aTmp = arr[a];
        arr[a] = arr[b];
        arr[b] = aTmp;
    }
}