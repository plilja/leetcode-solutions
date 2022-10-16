class Solution {
    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int depth = getDepth(node);
        if (isCompletelyFull(node)) {
            return (1 << depth) - 1;
        } else {
            if (isCompletelyFull(node.left)) {
                int leftSize = (1 << (depth - 1)) - 1;
                return countNodes(node.right) + 1 + leftSize;
            } else {
                int rightSize = (1 << (depth - 2)) - 1;
                return countNodes(node.left) + 1 + rightSize;
            }
        }
    }
    
    private boolean isCompletelyFull(TreeNode node) {
        TreeNode goingLeft = node;
        TreeNode goingRight = node;
        while (goingLeft != null && goingRight != null) {
            goingLeft = goingLeft.left;
            goingRight = goingRight.right;
        }
        return goingLeft == null && goingRight == null;
    }
    
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getDepth(node.left);
        }
    }
}