class BSTIterator(root: TreeNode?) {
    val stack = ArrayDeque<TreeNode>()

    init {
        visit(root)
    }
    
    fun visit(node: TreeNode?) {
        var curr : TreeNode? = node
        while (curr != null) {
            stack.addLast(curr)
            curr = curr.left
        }
    }

    fun next(): Int {
        val node = stack.removeLast()
        if (node.right != null) {
            visit(node.right)
        }
        return node.`val`
    }

    fun hasNext(): Boolean {
        return !stack.isEmpty()
    }

}

