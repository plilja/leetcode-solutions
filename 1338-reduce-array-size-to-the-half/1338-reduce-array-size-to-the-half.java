class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> numberToCount = new HashMap<>();
        for (int n : arr) {
            numberToCount.merge(n, 1, (a, b) -> a + b);
        }
        List<Integer> counts = new ArrayList<>(numberToCount.values());
        counts.sort((a, b) -> b - a);
        int result = 0;
        int acc = 0;
        for (int count : counts) {
            acc += count;
            result++;
            int target = (arr.length + 1) / 2;
            if (acc >= target) {
                break;
            }
        }
        return result;
    }
}