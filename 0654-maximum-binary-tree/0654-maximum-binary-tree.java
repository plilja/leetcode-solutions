class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }
        int maxIdx = from;
        for (int i = from + 1; i <= to; ++i) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode result = new TreeNode(nums[maxIdx]);
        result.left = constructMaximumBinaryTree(nums, from, maxIdx - 1);
        result.right = constructMaximumBinaryTree(nums, maxIdx + 1, to);
        return result;
    }
}