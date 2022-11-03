class Solution {
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        node.left = removeLeafNodes(node.left, target);
        node.right = removeLeafNodes(node.right, target);
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        } else {
            return node;
        }
    }
}