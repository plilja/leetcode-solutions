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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<TreeNodeHash, Integer> counter = new HashMap<>();
        helper(new TreeNodeHash(root), counter);
        List<TreeNode> result = new ArrayList<>();
        for (var entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey().node);
            }
        }
        return result;
    }

    private void helper(TreeNodeHash node, Map<TreeNodeHash, Integer> counter) {
        if (node != null) {
            counter.merge(node, 1, Integer::sum);
            helper(node.leftNodeHash, counter);
            helper(node.rightNodeHash, counter);
        }
    }

    private class TreeNodeHash {
        public final TreeNode node;
        public final int value;
        public final TreeNodeHash leftNodeHash;
        public final TreeNodeHash rightNodeHash;
        private Integer cachedHashCode = null;

        private TreeNodeHash(TreeNode treeNode) {
            this.node = treeNode;
            if (treeNode == null) {
                value = Integer.MIN_VALUE;
                leftNodeHash = null;
                rightNodeHash = null;
            } else {
                value = treeNode.val;
                if (treeNode.left != null) {
                    leftNodeHash = new TreeNodeHash(treeNode.left);
                } else {
                    leftNodeHash = null;
                }
                if (treeNode.right != null) {
                    rightNodeHash = new TreeNodeHash(treeNode.right);
                } else {
                    rightNodeHash = null;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            TreeNodeHash that = (TreeNodeHash) o;
            return Objects.equals(value, that.value)
                    && Objects.equals(leftNodeHash, that.leftNodeHash)
                    && Objects.equals(rightNodeHash, that.rightNodeHash);
        }

        @Override
        public int hashCode() {
            if (cachedHashCode == null) {
                cachedHashCode = Objects.hash(value, leftNodeHash, rightNodeHash);
            }
            return cachedHashCode;
        }
    }
}

