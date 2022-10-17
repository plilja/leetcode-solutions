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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>(); 
        Deque<Integer> depths = new ArrayDeque<>(); 
        if (root == null) {
            return result;
        }
        q.add(root);
        depths.add(0);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            int depth = depths.poll();
            if (depth == result.size()) {
                result.add(n.val);
            }
            if (n.right != null) {
                q.add(n.right);
                depths.add(depth + 1);
            }
            if (n.left != null) {
                q.add(n.left);
                depths.add(depth + 1);
            }
        }
        return result;
    }
}