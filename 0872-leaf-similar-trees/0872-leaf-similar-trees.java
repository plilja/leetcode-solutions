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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeaves(root1).equals(getLeaves(root2));
    }
    
    private List<Integer> getLeaves(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        getLeavesHelper(node, result);
        return result;
    }
    
    private void getLeavesHelper(TreeNode root, List<Integer> result) {
        if (root.left == null && root.right == null) {
            result.add(root.val);
        } else {
            if (root.left != null) {
                getLeavesHelper(root.left, result);
            }
            if (root.right != null) {
                getLeavesHelper(root.right, result);
            }
        }
    }
}