class Solution {
    fun longestConsecutive(root: TreeNode?): Int {
        return solve(root).second
    }

    fun solve(node: TreeNode?): Pair<Int, Int> {
        if (node == null) {
            return Pair(0, 0)
        } else {
            var increasing = 1
            var total = 1
            if (node.left != null) {
                val (increasingLeft, totalLeft) = solve(node.left)
                total = maxOf(total, totalLeft)
                if (node.left!!.`val` == node.`val` + 1) {
                    increasing = maxOf(increasing, increasingLeft + 1)
                }
            }
            if (node.right != null) {
                val (increasingRight, totalRight) = solve(node.right)
                total = maxOf(total, totalRight)
                if (node.right!!.`val` == node.`val` + 1) {
                    increasing = maxOf(increasing, increasingRight + 1)
                }
            }
            total = maxOf(total, increasing)
            return Pair(increasing, total)
        }
    }
}
