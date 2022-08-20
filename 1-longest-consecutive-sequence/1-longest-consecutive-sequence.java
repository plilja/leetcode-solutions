class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int n : nums) {
            numbers.add(n);
        }
        int result = 0;
        for (int n : nums) {
            if (numbers.contains(n)) {
                int seq = 0;
                int k = n;
                while (numbers.contains(k)) {
                    seq++;
                    numbers.remove(k);
                    k--;
                }
                k = n + 1;
                while (numbers.contains(k)) {
                    seq++;
                    numbers.remove(k);
                    k++;
                }
                result = Math.max(result, seq);
            }
        }
        return result;
    }
}
