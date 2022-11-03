class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root, new HashMap<>());
    }
    
    private TreeNode solve(TreeNode node, Map<TreeNode, Integer> cache) {
        int depthLeft = getDepth(node.left, cache);
        int depthRight = getDepth(node.right, cache);
        if (depthLeft == depthRight) {
            return node;
        } else if (depthLeft > depthRight) {
            return solve(node.left, cache);
        } else {
            return solve(node.right, cache);
        }
    }
    
    private int getDepth(TreeNode node, Map<TreeNode, Integer> cache) {
        if (node == null) {
            return 0;
        }
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        int result = 1 + Math.max(getDepth(node.left, cache), getDepth(node.right, cache));
        cache.put(node, result);
        return result;
    }
}