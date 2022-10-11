class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        root?.let { queue.add(Pair(it, 0)) }
        var deepestLevel = -1
        var result = -1
        while (queue.isNotEmpty()) {
            val (node, depth) = queue.removeFirst()
            if (depth > deepestLevel) {
                deepestLevel = depth
                result = node.`val`
            }
            node.left?.let { queue.add(Pair(it, depth + 1)) }
            node.right?.let { queue.add(Pair(it, depth + 1)) }
        }
        return result
    }
}
