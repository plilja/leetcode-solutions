/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        } else if (depth == 2) {
            var left = new TreeNode(val, root.left, null);
            var right = new TreeNode(val, null, root.right);
            return new TreeNode(root.val, left, right);
        } else {
            if (root.left != null) {
                root.left = addOneRow(root.left, val, depth - 1);
            }
            if (root.right != null) {
                root.right = addOneRow(root.right, val, depth - 1);
            }
            return root;
        }
    }
}

