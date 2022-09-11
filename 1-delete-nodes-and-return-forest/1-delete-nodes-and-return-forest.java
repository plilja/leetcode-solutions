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
    public List<TreeNode> delNodes(TreeNode root, int[] to_deleteArr) {
        Set<Integer> toDelete = new HashSet<>();
        for (int n : to_deleteArr) {
            toDelete.add(n);
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        
        q.add(root);
        if (!toDelete.contains(root.val)) {
            result.add(root);
        }
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            
            TreeNode parent = parentMap.get(node);
            if (!toDelete.contains(node.val) && parent != null && toDelete.contains(parent.val)) {
                result.add(node);
            }
            
            TreeNode left = node.left;
            if (left != null) {
                if (toDelete.contains(left.val)) {
                    node.left = null;
                }
                q.add(left);
                parentMap.put(left, node);
            }
            TreeNode right = node.right;
            if (right != null) {
                if (toDelete.contains(right.val)) {
                    node.right = null;
                }
                q.add(right);
                parentMap.put(right, node);
            }
        }
        return result;
    }
    
}
