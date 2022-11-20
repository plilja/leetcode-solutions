class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int depth = getDepth(root);
        return sumAtDepth(root, depth, 1);
    }
    
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
    
    private int sumAtDepth(TreeNode node, int depth, int currentDepth) {
        if (depth == currentDepth) {
            if (node == null) {
                return 0;
            } else {
                return node.val;
            }
        } else if (currentDepth < depth) {
            int result = 0;
            if (node.left != null) {
                result += sumAtDepth(node.left, depth, currentDepth + 1);
            }
            if (node.right != null) {
                result += sumAtDepth(node.right, depth, currentDepth + 1);
            }
            return result;
        } else {
            return 0;
        }
    }
}