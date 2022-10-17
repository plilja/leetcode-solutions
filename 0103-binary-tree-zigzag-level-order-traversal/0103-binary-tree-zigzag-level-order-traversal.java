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
    record ValueAndDepth(int value, int depth) {}
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<ValueAndDepth> nodes = new ArrayList<>();
        visit(root, 0, nodes);
        TreeMap<Integer, List<Integer>> depthToValues = new TreeMap<>();
        for (ValueAndDepth valueAndDepth : nodes) {
            depthToValues.computeIfAbsent(valueAndDepth.depth(), k -> new ArrayList<>()).add(valueAndDepth.value());
        }
        List<List<Integer>> result = new ArrayList<>();
        for (var entry : depthToValues.entrySet()) {
            int depth = entry.getKey();
            List<Integer> values = entry.getValue();
            if (depth % 2 == 1) {
                Collections.reverse(values);
            }
            result.add(values);
        }
        return result;
    }
    
    public void visit(TreeNode node, int depth, List<ValueAndDepth> result) {
        if (node != null) {
            result.add(new ValueAndDepth(node.val, depth));
            visit(node.left, depth + 1, result);
            visit(node.right, depth + 1, result);
        }
    }
}
