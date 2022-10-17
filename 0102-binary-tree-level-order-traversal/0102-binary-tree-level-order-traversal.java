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
    record QueueItem(TreeNode node, int depth) {}
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<QueueItem> q = new ArrayDeque<>();
        q.add(new QueueItem(root, 0));
        int previousDepth = -1;
        while (!q.isEmpty()) {
            var item = q.poll();
            if (item.depth() != previousDepth) {
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(item.node.val);
            if (item.node().left != null) {
                q.add(new QueueItem(item.node().left, item.depth() + 1));
            }
            if (item.node().right != null) {
                q.add(new QueueItem(item.node().right, item.depth() + 1));
            }
            previousDepth = item.depth();
        }
        return result;
    }
}
