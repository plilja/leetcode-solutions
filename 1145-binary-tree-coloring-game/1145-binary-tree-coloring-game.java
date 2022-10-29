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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findNode(root, x);
        int xSize = getSizeFrom(xNode);
        int xNodeLeft = getSizeFrom(xNode.left);
        int xNodeRight = getSizeFrom(xNode.right);
        int totalSize = getSizeFrom(root);
        if (totalSize - xSize > xSize) {
            return true; // choose parent of x
        }
        if (xNodeLeft > totalSize - xNodeLeft) {
            return true; // choose left child of x
        }
        if (xNodeRight > totalSize - xNodeRight) {
            return true; // choose right child of x
        }
        return false;
    }
    
    private TreeNode findNode(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }
        TreeNode foundLeft = findNode(root.left, x);
        if (foundLeft != null) {
            return foundLeft;
        }
        return findNode(root.right, x);
    }
    
    private int getSizeFrom(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getSizeFrom(node.left) + getSizeFrom(node.right) + 1;
    }
}