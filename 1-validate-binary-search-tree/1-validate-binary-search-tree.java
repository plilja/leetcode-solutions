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
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root).isValid();
    }
    
    private TreeInfo isValidHelper(TreeNode node) {
        if (node == null) {
            return new TreeInfo(null, null, true);
        } else {
            int min = node.val;
            int max = node.val;
            if (node.left != null) {
                TreeInfo left = isValidHelper(node.left);
                if (!left.isValid() || left.max() >= node.val) {
                    return new TreeInfo(null, null, false);
                }
                min = left.min();
            }
            if (node.right != null) {
                TreeInfo right = isValidHelper(node.right);
                if (!right.isValid() || right.min() <= node.val) {
                    return new TreeInfo(null, null, false);
                }
                max = right.max();
            }
            return new TreeInfo(min, max, true);
        }
    }
    
    private record TreeInfo(Integer min, Integer max, boolean isValid) {}
}
