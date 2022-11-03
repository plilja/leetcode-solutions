class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return solve(root, target);
    }
    
    private TreeNode solve(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        node.left = solve(node.left, target);
        node.right = solve(node.right, target);
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        } else {
            return node;
        }
    }
}