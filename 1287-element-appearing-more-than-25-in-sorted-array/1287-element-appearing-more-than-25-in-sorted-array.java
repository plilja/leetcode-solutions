class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        int target = (int) Math.floor(arr.length * 0.25);
        int highest = 0;
        int highestCount = 0;
        for (int n : arr) {
            int count = counts.merge(n, 1, (a, b) -> a + b);
            if (count > highestCount) {
                highest = n;
                highestCount = count;
            }
        }
        return highest;
    }
}