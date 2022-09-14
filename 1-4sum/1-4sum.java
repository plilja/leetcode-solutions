class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return List.of(); // no solutions
        }
        Arrays.sort(nums);
        Map<Long, Set<Tuple>> twoSums = new HashMap<>();
        twoSums.computeIfAbsent((long) nums[0] + nums[1], k -> new HashSet<>()).add(new Tuple(nums[0], nums[1]));
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 2; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                long sum = nums[i] + nums[j];
                long rem = target - sum;
                for (var t : twoSums.getOrDefault(rem, Set.of())) {
                    result.add(List.of(t.a(), t.b(), nums[i], nums[j]));
                }
            }
            for (int j = i - 1; j >= 0; --j) {
                long sum = nums[i] + nums[j];
                twoSums.computeIfAbsent(sum, k -> new HashSet<>()).add(new Tuple(nums[j], nums[i]));
            }
        }
        return new ArrayList<>(result);
    }
    
    private record Tuple(int a, int b) {
    }
}
