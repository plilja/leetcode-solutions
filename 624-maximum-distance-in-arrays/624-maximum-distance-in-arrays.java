class Solution {
    private static final int LARGE = 10000000;

    public int maxDistance(List<List<Integer>> arrays) {
        int largest = -LARGE;
        int smallest = LARGE;
        int result = -LARGE;
        for (var arr : arrays) {
            int min = LARGE;
            int max = -LARGE;
            for (int i : arr) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            result = Math.max(result, largest - min);
            result = Math.max(result, max - smallest);
            smallest = Math.min(smallest, min);
            largest = Math.max(largest, max);
        }
        return result;
    }
}

