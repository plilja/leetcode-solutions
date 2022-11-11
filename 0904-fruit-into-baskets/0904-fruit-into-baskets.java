class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> counts = new HashMap<>();
        int result = 0;
        int left = -1;
        for (int i = 0; i < fruits.length; ++i) {
            counts.merge(fruits[i], 1, (a, b) -> a + b);
            while (counts.size() > 2) {
                left++;
                int f = fruits[left];
                int newCount = counts.merge(f, -1, (a, b) -> a + b);
                if (newCount == 0) {
                    counts.remove(f);
                }
            }
            result = Math.max(result, i - left);
        }
        return result;
    }
}