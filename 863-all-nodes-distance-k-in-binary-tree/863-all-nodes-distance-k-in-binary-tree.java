/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        Map<TreeNode, Integer> dist = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(target);
        dist.put(target, 0);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int d = dist.get(node);
            if (d == k) {
                result.add(node.val);
            }
            TreeNode p = parent.get(node);
            if (p != null && !dist.containsKey(p)) {
                dist.put(p, d + 1);
                q.add(p);
            }
            if (node.left != null && !dist.containsKey(node.left)) {
                dist.put(node.left, d + 1);
                q.add(node.left);
            }
            if (node.right != null && !dist.containsKey(node.right)) {
                dist.put(node.right, d + 1);
                q.add(node.right);
            }
        }
        return result;
    }
    
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> parent) {
        if (node.left != null) {
            parent.put(node.left, node);
            dfs(node.left, parent);
        }
        if (node.right != null) {
            parent.put(node.right, node);
            dfs(node.right, parent);
        }
    }
}
