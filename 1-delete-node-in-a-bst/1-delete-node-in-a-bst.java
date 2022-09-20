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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // root.val == key
            if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
                return root;
            } else if (root.left != null) {
                root.val = predessor(root);
                root.left = deleteNode(root.left, root.val);
                return root;
            } else {
                // leaf
                return null;
            }
        }
    }
    
    private int successor(TreeNode node) {
        TreeNode current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }
    
    private int predessor(TreeNode node) {
        TreeNode current = node.left;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }
}
