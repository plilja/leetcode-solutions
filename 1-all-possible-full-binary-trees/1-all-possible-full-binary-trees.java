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
    private final HashMap<Integer, List<TreeNode>> cache = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 0) {
            List<TreeNode> result = new ArrayList<>();
            result.add(null);
            return result;
        } else if (n == 1) {
            return List.of(new TreeNode(0));
        } else {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            List<TreeNode> result = new ArrayList<>();
            for (int nrNodesLeft = 0; nrNodesLeft < n; ++nrNodesLeft) {
                int nrNodesRight = n - nrNodesLeft - 1;
                List<TreeNode> leftPossibilities = allPossibleFBT(nrNodesLeft);
                List<TreeNode> rightPossibilities = allPossibleFBT(nrNodesRight);
                for (TreeNode left : leftPossibilities) {
                    for (TreeNode right : rightPossibilities) {
                        if ((left == null && right == null) || (left != null && right != null)) {
                            TreeNode root = new TreeNode(0);
                            root.left = clone(left);
                            root.right = clone(right);
                            result.add(root);
                        }
                    }
                }
            }
            cache.put(n, result);
            return result;
        }
    }
    
    private TreeNode clone(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode result = new TreeNode(root.val);
            result.left = clone(root.left);
            result.right = clone(root.right);
            return result;
        }
    }
}
