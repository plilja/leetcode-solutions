class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result);
        return result;
    }
    
    private void solve(TreeNode node, List<Integer> result) {
        if (node.left != null || node.right != null) {
            if (node.left == null) {
                result.add(node.right.val);
            }
            if (node.right == null) {
                result.add(node.left.val);
            }
            if (node.left != null) {
                solve(node.left, result);
            } 
            if (node.right != null) {
                solve(node.right, result);
            } 
        }
    }
}