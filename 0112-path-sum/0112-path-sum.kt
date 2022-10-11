class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return root?.let { hasPathSum(it, targetSum, 0) } ?: false
    }

    private fun hasPathSum(node: TreeNode, targetSum: Int, currentSum: Int): Boolean {
        var newCurrentSum = currentSum
        newCurrentSum += node.`val`
        if (isLeaf(node) && newCurrentSum == targetSum) {
            return true
        }
        if (node.left != null && hasPathSum(node.left!!, targetSum, newCurrentSum)) {
            return true
        }
        if (node.right != null && hasPathSum(node.right!!, targetSum, newCurrentSum)) {
            return true
        }
        return false
    }
    
    private fun isLeaf(node: TreeNode) = node.left == null && node.right == null
}
