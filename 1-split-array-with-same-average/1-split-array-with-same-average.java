/*

[1,2,3,4,5,6,7,8]
3 5


*/
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum = getSum(nums);
        Arrays.sort(nums);
        for (int part1 = 1; part1 <= nums.length - 1; ++part1) {
            int part2 = nums.length - part1;
            // (x) / part1 == (sum - x) / part2
            // x * part2 == sum*part1 - x * part1
            // x * (part2 + part1) == sum * part1
            // x == sum * part1 / (part1 + part2)
            
            if (sum * part1 % (part1 + part2) == 0) {
                int target = sum * part1 / (part1 + part2);
                if (possible(nums, new Params(0, target, part1), new HashMap<>())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean possible(int[] nums, Params params, Map<Params, Boolean> cache) {
        Boolean cached = cache.get(params);
        if (cached != null) {
            return cached;
        }
        if (params.numToPick == 0) {
            return params.target == 0;
        }
        for (int i = params.start; i < nums.length; ++i) {
            int value = nums[i];
            if (value <= params.target) {
                if (possible(nums, new Params(i + 1, params.target - value, params.numToPick - 1), cache)) {
                    cache.put(params, true);
                    return true;
                }
            }
        }
        cache.put(params, false);
        return false;
    }
    
    private int getSum(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result += n;
        }
        return result;
    }
    
    private record Params (int start, int target, int numToPick) {
    }
}
