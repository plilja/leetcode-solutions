class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        helper(result, comb, candidates, target, 0);
        return result;
    }
    
    private void helper(
        List<List<Integer>> result,
        List<Integer> comb,
        int[] candidates,
        int remain,
        int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            helper(result, comb, candidates, remain - candidates[i], i);
            comb.remove(comb.size() - 1);
        }
    }
}
