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
    public List<String> binaryTreePaths(TreeNode root) {
        Deque<Integer> path = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        if (root != null) {
            solve(root, path, result);
        }
        return result;
    }

    private void solve(TreeNode node, Deque<Integer> path, List<String> result) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            // leaf
            String p = path.stream()
                .map(i -> String.valueOf(i))
                .collect(Collectors.joining("->"));
            result.add(p);
        } 
        if (node.left != null) {
            solve(node.left, path, result);
        }
        if (node.right != null) {
            solve(node.right, path, result);
        }
        path.removeLast();
    }
}