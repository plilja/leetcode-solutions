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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }
        if (root1.val != root2.val) {
            return false;
        }
        if (childCount(root1) != childCount(root2)) {
            return false;
        }
        if (root1.left != null && root1.right != null) {
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                   ||
                   (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        } else if (root1.left != null) {
            if (root2.left != null) {
                return flipEquiv(root1.left, root2.left);
            } else {
                return flipEquiv(root1.left, root2.right);
            }
        } else if (root1.right != null) {
            if (root2.left != null) {
                return flipEquiv(root1.right, root2.left);
            } else {
                return flipEquiv(root1.right, root2.right);
            }
        } else {
            // no child nodes
            return true;
        }
    }
    
    private int childCount(TreeNode node) {
        int result = 0;
        result += node.left != null ? 1 : 0;
        result += node.right != null ? 1 : 0;
        return result;
    }
}