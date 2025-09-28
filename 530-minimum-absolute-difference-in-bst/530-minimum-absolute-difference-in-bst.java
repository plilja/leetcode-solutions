class Solution {
    private static final int LARGE = 10000000;

    public int getMinimumDifference(TreeNode root) {
        return helper(root, LARGE, LARGE);
    }

    private int helper(TreeNode node, int leftBound, int rightBound) {
        int result = LARGE;
        if (node != null) {
            result = Math.min(result, Math.abs(leftBound - node.val));
            result = Math.min(result, Math.abs(rightBound - node.val));
            result = Math.min(result, helper(node.left, leftBound, node.val));
            result = Math.min(result, helper(node.right, node.val, rightBound));
        }
        return result;
    }
}

