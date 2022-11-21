class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int acc = 0;
        int result = 0;
        for (int apple : weight) {
            if (acc + apple <= 5000) {
                acc += apple;
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}