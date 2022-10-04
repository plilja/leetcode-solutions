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
    public int rob(TreeNode root) {
        return robHelper(root, true, new HashMap<>());
    }
    
    private int robHelper(TreeNode node, boolean rootAllowed, Map<TreeNode, Map<Boolean, Integer>> cache) {
        if (node == null) {
            return 0;
        }
        var subCache = cache.computeIfAbsent(node, k -> new HashMap<>());
        if (subCache.containsKey(rootAllowed)) {
            return subCache.get(rootAllowed);
        }
        int ans = robHelper(node.left, true, cache) + robHelper(node.right, true, cache);
        if (rootAllowed) {
            int subAns = node.val + robHelper(node.left, false, cache) + robHelper(node.right, false, cache);
            ans = Math.max(ans, subAns);
        }
        subCache.put(rootAllowed, ans);
        return ans;
    }
}