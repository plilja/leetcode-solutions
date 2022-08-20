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
    record Ans (boolean pFound, boolean qFound, TreeNode common) {}
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).common();
    }
    
    private Ans helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Ans(false, false, null);
        }
        boolean pFound = root == p;
        boolean qFound = root == q;
        Ans subAns1 = helper(root.left, p, q);
        if (subAns1.common() != null) {
            return subAns1;
        }
        Ans subAns2 = helper(root.right, p, q);
        if (subAns2.common() != null) {
            return subAns2;
        }
        pFound = pFound || subAns1.pFound();
        pFound = pFound || subAns2.pFound();
        qFound = qFound || subAns1.qFound();
        qFound = qFound || subAns2.qFound();
        if (pFound && qFound) {
            return new Ans(true, true, root);
        }
        return new Ans(pFound, qFound, null);
    }
}
