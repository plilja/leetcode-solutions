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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, Integer.MIN_VALUE, Integer.MAX_VALUE).node();
    }
    
    private Pair helper(int[] preorder, int start, int min, int max) {
        if (start < preorder.length) {
            int n = preorder[start];
            if (min <= n && n <= max) {
                TreeNode result = new TreeNode(n);
                Pair left = helper(preorder, start + 1, min, n - 1);
                if (left.node() != null) {
                    result.left = left.node();
                }
                Pair right = helper(preorder, left.index(), n + 1, max);
                if (right.node() != null) {
                    result.right = right.node();
                }
                return new Pair(result, right.index());
            }
        }
        return new Pair(null, start);
    }
    
    record Pair(TreeNode node, int index) {}
}
