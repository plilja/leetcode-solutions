import java.util.concurrent.atomic.AtomicInteger

class Codec() {
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val result = StringBuilder()
        serializeHelper(root, result)
        return result.toString()
    }

    private fun serializeHelper(node: TreeNode, result: StringBuilder) {
        if (result.isNotEmpty()) {
            result.append(",")
        }
        result.append(node.`val`)
        result.append(",")
        result.append(if (node.left == null) 0 else 1)
        result.append(",")
        result.append(if (node.right == null) 0 else 1)
        node.left?.let { serializeHelper(it, result) }
        node.right?.let { serializeHelper(it, result) }
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }
        val args = data.split(",").map { it.toInt() }.toList()
        return deserializeHelper(args, AtomicInteger(0))
    }

    private fun deserializeHelper(args: List<Int>, i: AtomicInteger): TreeNode? {
        if (args.size == i.get()) {
            return null
        }
        val v = args[i.getAndIncrement()]
        val node = TreeNode(v)
        val left = args[i.getAndIncrement()]
        val right = args[i.getAndIncrement()]
        if (left == 1) {
            node.left = deserializeHelper(args, i)
        }
        if (right == 1) {
            node.right = deserializeHelper(args, i)
        }
        return node
    }
}