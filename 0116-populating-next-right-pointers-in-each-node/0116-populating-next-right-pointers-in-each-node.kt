/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */
class Solution {
    fun connect(root: Node?): Node? {
        val queue = ArrayDeque<Pair<Node, Int>>()
        root?.let { queue.addLast(Pair(it, 0)) }
        var prevDepth = -1
        var prevNode: Node? = null
        while (!queue.isEmpty()) {
            val (node, depth) = queue.removeFirst()
            if (depth != prevDepth) {
                prevDepth = depth
                prevNode = null
            } 
            node.next = prevNode
            node.right?.let { queue.addLast(Pair(it, depth + 1)) }
            node.left?.let { queue.addLast(Pair(it, depth + 1)) }
            prevNode = node
        }
        return root
    }
}
