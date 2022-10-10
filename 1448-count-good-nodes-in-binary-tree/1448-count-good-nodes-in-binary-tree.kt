class Solution {
    fun goodNodes(node: TreeNode?, maxInPath: Int = Int.MIN_VALUE): Int {
        var result = 0
        if (node != null) {
            if (node.`val` >= maxInPath) {
                result++
            }
            result += goodNodes(node.left, maxOf(maxInPath, node.`val`))
            result += goodNodes(node.right, maxOf(maxInPath, node.`val`))
        }
        return result
    }
}