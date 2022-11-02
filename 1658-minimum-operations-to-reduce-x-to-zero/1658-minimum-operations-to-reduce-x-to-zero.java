class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Long, Integer> suffixSums = new HashMap<>();
        long accRight = 0;
        suffixSums.put(accRight, 0);
        for (int i = nums.length - 1; i >= 0; --i) {
            accRight += nums[i];
            suffixSums.put(accRight, nums.length - i);
        }
        int result = Integer.MAX_VALUE;
        long accLeft = 0;
        for (int i = -1; i < nums.length; ++i) {
            if (i >= 0) {
                int n = nums[i];
                accLeft += n;
                suffixSums.remove(accRight);
                accRight -= n;
            }
            long rem = x - accLeft;
            if (suffixSums.containsKey(rem)) {
                int subsolution = i + 1 + suffixSums.get(rem);
                result = Math.min(result, subsolution);
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}