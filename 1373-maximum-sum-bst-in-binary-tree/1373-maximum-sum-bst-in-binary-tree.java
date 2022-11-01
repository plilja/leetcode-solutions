class Solution {
    public int maxSumBST(TreeNode root) {
        AtomicInteger result = new AtomicInteger(0);
        solve(root, result);
        return result.get();
    }
    
    private TreeInfo solve(TreeNode node, AtomicInteger result) {
        int sum = node.val;
        int min = node.val;
        int max = node.val;
        boolean leftValid = true;
        if (node.left != null) {
            leftValid = node.left.val < node.val;
            TreeInfo left = solve(node.left, result);
            leftValid = leftValid && left.bst && left.max < node.val;
            min = left.min;
            sum += left.sum;
        }
        boolean rightValid = true;
        if (node.right != null) {
            rightValid = node.right.val > node.val;
            TreeInfo right = solve(node.right, result);
            rightValid = rightValid && right.bst && right.min > node.val;
            max = right.max;
            sum += right.sum;
        }
        boolean valid = leftValid && rightValid;
        if (valid) {
            result.set(Math.max(result.get(), sum));
        }
        return new TreeInfo(sum, valid, min, max);
    }
    
    private record TreeInfo(int sum, boolean bst, int min, int max) {
    }
}