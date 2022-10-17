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
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Long> rightmost = new HashMap<>(); 
        Map<Integer, Long> leftmost = new HashMap<>(); 
        determineWidths(root, 0, 0, rightmost, leftmost);
        long result = 0;
        for (var entry : leftmost.entrySet()) {
            long left = entry.getValue();
            long right = rightmost.get(entry.getKey());
            result = Math.max(result, right - left + 1);
        }
        return (int) result;
    }
    
    private void determineWidths(TreeNode node, int depth, long index, Map<Integer, Long> rightmost, Map<Integer, Long> leftmost) {
        if (node == null) {
            return;
        }
        rightmost.merge(depth, index, (a, b) -> Math.max(a, b));
        leftmost.merge(depth, index, (a, b) -> Math.min(a, b));
        determineWidths(node.left, depth + 1, 2 * index, rightmost, leftmost);
        determineWidths(node.right, depth + 1, 2 * index + 1, rightmost, leftmost);
    }
}
