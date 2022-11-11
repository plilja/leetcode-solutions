class Solution {
    public int sumRootToLeaf(TreeNode root) {
        AtomicInteger result = new AtomicInteger(0);
        solve(root, "", result);
        return result.get();
    }
    
    private void solve(TreeNode node, String current, AtomicInteger result) {
        boolean isLeaf = node.left == null && node.right == null;
        if (isLeaf) {
            int path = Integer.parseInt(current + String.valueOf(node.val), 2);
            result.set(result.get() + path);
        } else {
            if (node.left != null) {
                solve(node.left, current + String.valueOf(node.val), result);
            }
            if (node.right != null) {
                solve(node.right, current + String.valueOf(node.val), result);
            }
        }
    }
}