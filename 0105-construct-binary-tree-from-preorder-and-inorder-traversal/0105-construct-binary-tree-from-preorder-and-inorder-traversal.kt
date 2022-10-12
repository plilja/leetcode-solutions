class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTree(preorder, inorder, 0, 0, inorder.size - 1)
    }

    private fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
        startPreorder: Int,
        startInorder: Int,
        endInorder: Int
    ): TreeNode? {
        if (startInorder > endInorder) {
            return null
        } else {
            val rootValue = preorder[startPreorder]
            var idx = -1
            for (i in startInorder..endInorder) {
                if (inorder[i] == rootValue) {
                    idx = i
                    break
                }
            }
            val root = TreeNode(rootValue)
            root.left = buildTree(preorder, inorder, startPreorder + 1, startInorder, idx - 1)
            root.right = buildTree(preorder, inorder, startPreorder + idx - startInorder + 1, idx + 1, endInorder)
            return root
        }
    }
}