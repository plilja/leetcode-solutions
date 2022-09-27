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
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.peekFirst() != null) {
            TreeNode n = q.pollFirst();
            q.addLast(n.left);
            q.addLast(n.right);
        }
        while (!q.isEmpty() && q.peekFirst() == null) {
            q.pollFirst();
        }
        return q.isEmpty();
    }
}