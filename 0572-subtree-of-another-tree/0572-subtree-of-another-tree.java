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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        } else {
            if (root.val == subRoot.val) {
                boolean leftEqual = isEqual(root.left, subRoot.left);
                boolean rightEqual = isEqual(root.right, subRoot.right);
                if (leftEqual && rightEqual) {
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    
    private boolean isEqual(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null || nodeB == null) {
            return nodeA == null && nodeB == null;
        } else {
            return nodeA.val == nodeB.val && isEqual(nodeA.left, nodeB.left) && isEqual(nodeA.right, nodeB.right);
        }
    }
}
