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
    public int findTilt(TreeNode root) {
        Pair result = helper(root);
        return result.left;
    }

    private Pair helper(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair a = helper(node.left);
        Pair b = helper(node.right);
        int tilt = Math.abs(a.right - b.right);
        return new Pair(a.left + b.left + tilt, a.right + b.right + node.val);

    }

    private record Pair(int left, int right) {
    }
}
