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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(getLeftBoundary(root));
        result.addAll(getLeaves(root));
        List<Integer> rightBoundary = getRightBoundary(root);
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);
        return result;
    }
    
    private List<Integer> getLeftBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            getBoundaryHelper(root.left, result, n -> n.left, n -> n.right);
        }
        return result;
    }
    
    private List<Integer> getRightBoundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.right != null) {
            getBoundaryHelper(root.right, result, n -> n.right, n -> n.left);
        }
        return result;
    }
    
    private void getBoundaryHelper(TreeNode node, 
                                   List<Integer> result,
                                   Function<TreeNode, TreeNode> first,
                                   Function<TreeNode, TreeNode> second) {
        if (!isLeaf(node)) {
            result.add(node.val);
            if (first.apply(node) != null) {
                getBoundaryHelper(first.apply(node), result, first, second);
            } else {
                getBoundaryHelper(second.apply(node), result, first, second);
            }
        }
    }
    
    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root.left != null) {
            getLeavesHelper(root.left, result);
        }
        if (root.right != null) {
            getLeavesHelper(root.right, result);
        }
        return result;
    }
    
    private void getLeavesHelper(TreeNode node, List<Integer> result) {
        if (isLeaf(node)) {
            result.add(node.val);
        } else {
            if (node.left != null) {
                getLeavesHelper(node.left, result);
            }
            if (node.right != null) {
                getLeavesHelper(node.right, result);
            }
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    
}
