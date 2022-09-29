/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true;
        } else {
            return isMirrored(root.left, root.right)
        }
    }
    
    fun isMirrored(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null
        } else {
            return node1.`val` == node2.`val` &&
                   isMirrored(node1.right, node2.left) &&
                   isMirrored(node1.left, node2.right)
        }
    }
}