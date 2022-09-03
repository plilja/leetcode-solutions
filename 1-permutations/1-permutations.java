class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, result, new ArrayList<>());
        return result;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                int n = nums[i];
                if (!current.contains(n)) {
                    current.add(n);
                    permuteHelper(nums, result, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
