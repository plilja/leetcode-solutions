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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return subtreeWithAllDeepestHelper(root, new HashMap<>());
    }
    
    private TreeNode subtreeWithAllDeepestHelper(TreeNode root, HashMap<TreeNode, Integer> cache) {
        if (root == null) {
            return null;
        }
        int left = getMaxDepth(root.left, cache);
        int right = getMaxDepth(root.right, cache);
        if (left == right) {
            return root;
        } else if (left > right) {
            return subtreeWithAllDeepestHelper(root.left, cache);
        } else {
            return subtreeWithAllDeepestHelper(root.right, cache);
        }
    }
    
    private int getMaxDepth(TreeNode node, Map<TreeNode, Integer> cache) {
        if (node == null) {
            return 0;
        }
        var cached = cache.get(node);
        if (cached != null) {
            return cached;
        }
        int left = 0;
        if (node.left != null) {
            left = getMaxDepth(node.left, cache);
        }
        int right = 0;
        if (node.right != null) {
            right = getMaxDepth(node.right, cache);
        }
        int result = Math.max(left, right) + 1;
        cache.put(node, result);
        return result;
    }
}
