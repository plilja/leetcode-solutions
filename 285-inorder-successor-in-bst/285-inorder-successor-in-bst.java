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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        AtomicBoolean pVisited = new AtomicBoolean(false);
        AtomicReference<TreeNode> result = new AtomicReference<TreeNode>(null);
        inorder(root, node -> {
            if (node == p) {
                pVisited.set(true);
            } else  if (pVisited.get() && result.get() == null) {
                result.set(node);
            }
        });
        return result.get();
    }
    
    private void inorder(TreeNode node, Consumer<TreeNode> visitCallback) {
        if (node != null) {
            inorder(node.left, visitCallback);
            visitCallback.accept(node);
            inorder(node.right, visitCallback);
        }
    }
}
