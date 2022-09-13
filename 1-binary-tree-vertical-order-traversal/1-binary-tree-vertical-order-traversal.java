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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> balanceToNodes = new TreeMap<>();
        visit(root, balanceToNodes, 0, 0);
        int minBalance = balanceToNodes.firstKey();
        int maxBalance = balanceToNodes.lastKey();
        for (int i = minBalance; i <= maxBalance; ++i) {
            List<Integer> column = new ArrayList<>();
            for (List<Integer> values : balanceToNodes.get(i).values()) {
                column.addAll(values);
            }
            result.add(column);
        }
        return result;
    }
    
    private void visit(TreeNode node, TreeMap<Integer, TreeMap<Integer, List<Integer>>> balanceToNodes, int balance, int depth) {
        if (node == null) {
            return;
        } else {
            balanceToNodes.computeIfAbsent(balance, k -> new TreeMap<>())
                          .computeIfAbsent(depth, k -> new ArrayList<>())
                          .add(node.val);
            visit(node.left, balanceToNodes, balance - 1, depth + 1);
            visit(node.right, balanceToNodes, balance + 1, depth + 1);
        }
    }
}
