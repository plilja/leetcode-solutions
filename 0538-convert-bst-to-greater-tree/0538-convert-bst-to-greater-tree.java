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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            return helper(root, new AtomicInteger(0));
        }
    }
    
    private TreeNode helper(TreeNode node, AtomicInteger sumGreater) {
        TreeNode right = null;
        if (node.right != null) {
            right = helper(node.right, sumGreater);
        }
        sumGreater.set(sumGreater.get() + node.val);
        TreeNode result = new TreeNode(sumGreater.get());
        result.right = right;
        if (node.left != null) {
            result.left = helper(node.left, sumGreater);
        }
        return result;
    }
}