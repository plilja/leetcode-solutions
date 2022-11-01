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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> levels = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        double sum = 0;
        int count = 0;
        nodes.add(root);
        levels.add(0);
        int prevLevel = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int level = levels.poll();
            if (level != prevLevel) {
                result.add(sum / count);
                sum = 0;
                count = 0;
            }
            sum += node.val;
            count++;
            prevLevel = level;
            if (node.left != null) {
                nodes.add(node.left);
                levels.add(level + 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                levels.add(level + 1);
            }
        }
        result.add(sum / count);
        return result;
    }
}