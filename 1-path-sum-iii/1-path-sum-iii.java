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
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, (long) targetSum, 0, new HashMap<>());
    }
    
    private int dfs(TreeNode node, long targetSum, long currentSum, Map<Long, Integer> branchSums) {
        if (node == null) {
            return 0;
        }
        long newCurrentSum = currentSum + node.val;
        long rem = newCurrentSum - targetSum; 
        int result = branchSums.getOrDefault(rem, 0);
        branchSums.merge(newCurrentSum, 1, (a, b) -> a + b);
        if (newCurrentSum == targetSum) {
            result++;
        }
        result += dfs(node.left, targetSum, newCurrentSum, branchSums);
        result += dfs(node.right, targetSum, newCurrentSum, branchSums);
        branchSums.merge(newCurrentSum, -1, (a, b) -> a + b);
        return result;
    }
    
}
