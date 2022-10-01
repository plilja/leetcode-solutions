class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(arr[0], arr[1]));
        int bestDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; ++i) {
            int diff = arr[i + 1] - arr[i];
            if (diff == bestDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            } else if (diff < bestDiff) {
                result.clear();
                result.add(List.of(arr[i], arr[i + 1]));
                bestDiff = diff;
            }
        }
        return result;
    }
}