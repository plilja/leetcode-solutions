class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> intToMaxIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            intToMaxIndex.merge(nums[i], i, (a, b) -> Math.max(a, b));
        }
        Set<List<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                int b = nums[j];
                int rem = 0 - a - b;
                int k = intToMaxIndex.getOrDefault(rem, -1);
                if (k > j) {
                    int c = nums[k];
                    triplets.add(sorted(a, b, c));
                }
            }
        }
        return new ArrayList<>(triplets);
    }
    
    private List<Integer> sorted(int a, int b, int c) {
        List<Integer> result = new ArrayList<>(List.of(a, b, c));
        Collections.sort(result);
        return result;
    }
}
