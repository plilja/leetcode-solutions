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
    public int longestConsecutive(TreeNode root) {
        AtomicInteger result = new AtomicInteger(0);
        solve(root, result);
        return result.get();
    }
    
    private Paths solve(TreeNode node, AtomicInteger result) {
        int increasing = 0;
        int decreasing = 0;
        if (node.left != null) {
            Paths left = solve(node.left, result);
            if (node.left.val - 1 == node.val) {
                increasing = Math.max(increasing, left.increasing);
            }
            if (node.left.val + 1 == node.val) {
                decreasing = Math.max(decreasing, left.decreasing);
            }
        }
        if (node.right != null) {
            Paths right = solve(node.right, result);
            if (node.right.val - 1 == node.val) {
                increasing = Math.max(increasing, right.increasing);
            }
            if (node.right.val + 1 == node.val) {
                decreasing = Math.max(decreasing, right.decreasing);
            }
        }
        result.set(Math.max(result.get(), decreasing + increasing + 1));
        return new Paths(increasing + 1, decreasing + 1);
    }
    
    private record Paths(int increasing, int decreasing) {
        
    }
}