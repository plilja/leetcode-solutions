class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int fromInorder, int toInorder, int fromPostorder, int toPostorder) {
        if (fromInorder > toInorder) {
            return null;
        }
        int root = postorder[toPostorder];
        int i = fromInorder;
        while (i <= toInorder) {
            if (inorder[i] == root) {
                break;
            }
            i++;
        }
        int offset = i - fromInorder;
        TreeNode left = helper(inorder, postorder, fromInorder, i - 1, fromPostorder, fromPostorder + offset - 1);
        TreeNode right = helper(inorder, postorder, i + 1, toInorder, fromPostorder + offset, toPostorder - 1);
        return new TreeNode(root, left, right);
    }
    
}