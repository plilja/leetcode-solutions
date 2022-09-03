class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<Set<Integer>> result = new HashSet<>();
        subsetsHelper(nums, 0, result);
        List<List<Integer>> resultAsLists = new ArrayList<>();
        for (var sub : result) {
            resultAsLists.add(new ArrayList<>(sub));
        }
        return resultAsLists;
    }
    
    public void subsetsHelper(int[] nums, int from, Set<Set<Integer>> result) {
        if (from == nums.length) {
            result.add(new HashSet<>());
        } else {
            subsetsHelper(nums, from + 1, result);
            int first = nums[from];
            Set<Set<Integer>> newSolutions = new HashSet<>();
            for (var sol : result) {
                Set<Integer> newSol = new HashSet<>(sol);
                newSol.add(first);
                newSolutions.add(newSol);
            }
            result.addAll(newSolutions);
        }
    }
}
