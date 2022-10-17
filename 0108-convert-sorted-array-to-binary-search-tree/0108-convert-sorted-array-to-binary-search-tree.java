/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTreeHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode createTreeHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode result = new TreeNode(nums[middle]);
        result.left = createTreeHelper(nums, start, middle - 1);
        result.right = createTreeHelper(nums, middle + 1, end);
        return result;
    }
}
