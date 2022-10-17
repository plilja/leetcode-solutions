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
    
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        HashSet<TreeNode> toDelete = new HashSet<>();
        determineDeletion(root, toDelete, limit, 0);
        return delete(root, toDelete);
    }
    
    private TreeNode delete(TreeNode node, Set<TreeNode> toDelete) {
        if (node == null) {
            return null;
        } else if (toDelete.contains(node)) {
            return null;
        } else {
            node.left = delete(node.left, toDelete);
            node.right = delete(node.right, toDelete);
            return node;
        }
    }
        
    private int determineDeletion(TreeNode node, Set<TreeNode> toDelete, int limit, int acc) {
        if (node != null) {
            boolean isLeaf = node.left == null && node.right == null;
            if (isLeaf) {
                int result = acc + node.val;
                if (result < limit) {
                    toDelete.add(node);
                }
                return result;
            } else {
                int left = Integer.MIN_VALUE;
                if (node.left != null) {
                    left = determineDeletion(node.left, toDelete, limit, acc + node.val);
                }
                int right = Integer.MIN_VALUE;
                if (node.right != null) {
                    right = determineDeletion(node.right, toDelete, limit, acc + node.val);
                }
                int result = Math.max(left, right);
                if (result < limit) {
                    toDelete.add(node);
                }
                return result;
            }
        } else {
            return 0;
        }
    }
}
