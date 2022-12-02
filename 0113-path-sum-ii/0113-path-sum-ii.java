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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        solve(root, new ArrayList<>(), 0, targetSum, result);
        return result;
    }
    
    private void solve(TreeNode node, List<Integer> path, int current, int target, List<List<Integer>> result) {
        path.add(node.val);
        current += node.val;
        boolean isLeaf = node.left == null && node.right == null;
        if (isLeaf) {
            if (current == target) {
                result.add(new ArrayList<>(path));
            }
        } else {
            if (node.left != null) {
                solve(node.left, path, current, target, result);
            }
            if (node.right != null) {
                solve(node.right, path, current, target, result);
            }
        }
        path.remove(path.size() - 1);
    }
}