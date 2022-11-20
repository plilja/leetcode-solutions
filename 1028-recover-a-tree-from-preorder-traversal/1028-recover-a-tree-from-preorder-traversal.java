class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal, 0, 0).first;
    }

    private Pair<TreeNode, Integer> helper(String traversal, int i, int currDepth) {
        if (traversal.length() == i) {
            return null;
        }
        int depth = getDepth(traversal, i);
        if (depth != currDepth) {
            return null;
        }
        int nextDash = traversal.indexOf("-", i + depth);
        if (nextDash == -1) {
            nextDash = traversal.length();
        }
        String valStr = traversal.substring(i + depth, nextDash);
        int val = Integer.parseInt(valStr);
        TreeNode result = new TreeNode(val);
        var leftParse = helper(traversal, nextDash, currDepth + 1);
        if (leftParse == null) {
            return new Pair<>(result, nextDash);
        }
        result.left = leftParse.first;
        var rightParse = helper(traversal, leftParse.second, currDepth + 1);
        if (rightParse == null) {
            return new Pair<>(result, leftParse.second);
        }
        result.right = rightParse.first;
        return new Pair<>(result, rightParse.second);
    }

    private int getDepth(String traversal, int i) {
        int depth = 0;
        for (; depth < traversal.length(); ++depth) {
            if (traversal.charAt(i + depth) != '-') {
                break;
            }
        }
        return depth;
    }

    private record Pair<A, B>(A first, B second) {
    }
}
