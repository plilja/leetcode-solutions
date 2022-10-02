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
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffHelper(root, new AtomicInteger(), new AtomicInteger());
    }
    
    private int maxAncestorDiffHelper(TreeNode node, AtomicInteger min, AtomicInteger max) {
        AtomicInteger subMin = new AtomicInteger(node.val);
        AtomicInteger subMax = new AtomicInteger(node.val);
        int leftSubResult = 0;
        int rightSubResult = 0;
        if (node.left != null) {
            leftSubResult = maxAncestorDiffHelper(node.left, subMin, subMax);
        }
        if (node.right != null) {
            rightSubResult = maxAncestorDiffHelper(node.right, subMin, subMax);
        }
        min.set(Math.min(min.get(), Math.min(subMin.get(), node.val)));
        max.set(Math.max(max.get(), Math.max(subMax.get(), node.val)));
        int result = Math.abs(node.val - subMin.get());
        result = Math.max(result, Math.abs(node.val - subMax.get()));
        result = Math.max(result, leftSubResult);
        result = Math.max(result, rightSubResult);
        return result;
    }
}