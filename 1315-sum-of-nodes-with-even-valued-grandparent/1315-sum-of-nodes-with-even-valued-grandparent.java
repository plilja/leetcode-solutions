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
    public int sumEvenGrandparent(TreeNode root) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int result = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode parent = parents.get(node);
            if (parent != null) {
                TreeNode grandParent = parents.get(parent);
                if (grandParent != null && grandParent.val % 2 == 0) {
                    result += node.val;
                }
            }
            if (node.left != null) {
                parents.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                q.add(node.right);
            }
        }
        return result;
    }
}