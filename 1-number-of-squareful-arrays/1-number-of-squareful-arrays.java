class Solution {
    public int numSquarefulPerms(int[] nums) {
        List<Long> numLongs = new ArrayList<>();
        for (int n : nums) {
            numLongs.add((long) n);
        }
        return numSquarefulPermsHelper(numLongs, null);
    }
    
    private int numSquarefulPermsHelper(List<Long> nums, Long last) {
        if (nums.isEmpty()) {
            return 1;
        }
        int result = 0;
        Set<Long> tried = new HashSet<>();
        if (last == null) {
            int limit = nums.size();
            for (int i = 0; i < nums.size(); ++i) {
                long n = nums.get(i);
                if (!tried.contains(n)) {
                    tried.add(n);
                    nums.remove(i);
                    result += numSquarefulPermsHelper(nums, n);
                    nums.add(i, n);
                }
            }
        } else {
            int limit = nums.size();
            for (int i = 0; i < nums.size(); ++i) {
                long n = nums.get(i);
                if (!tried.contains(n)) {
                    tried.add(n);
                    long sum = n + last;
                    long sqrt = (long) Math.sqrt(sum);
                    if (sqrt * sqrt == sum) {
                        nums.remove(i);
                        result += numSquarefulPermsHelper(nums, n);
                        nums.add(i, n);
                    }
                }
            }
        }
        return result;
    }
}
