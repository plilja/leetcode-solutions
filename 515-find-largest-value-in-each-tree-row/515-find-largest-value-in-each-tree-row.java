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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();
        q.add(root);
        depths.add(0);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            int depth = depths.poll();
            if (depth >= result.size()) {
                result.add(n.val);
            } else if (result.get(depth) < n.val) {
                result.set(depth, n.val);
            }
            if (n.left != null) {
                depths.add(depth + 1);
                q.add(n.left);
            }
            if (n.right != null) {
                depths.add(depth + 1);
                q.add(n.right);
            }
        }
        return result;
    }
}