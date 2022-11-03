class Solution {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> qn = new ArrayDeque<>();
        Deque<Integer> ql = new ArrayDeque<>();
        Map<Integer, Integer> levelSums = new HashMap<>();
        qn.add(root);
        ql.add(1);
        while (!qn.isEmpty()) {
            TreeNode node = qn.pollFirst();
            int level  = ql.pollFirst();
            levelSums.merge(level, node.val, (a, b) -> a + b);
            if (node.left != null) {
                qn.add(node.left);
                ql.add(level + 1);
            }
            if (node.right != null) {
                qn.add(node.right);
                ql.add(level + 1);
            }
        }
        int highest = Integer.MIN_VALUE;
        int result = -1;
        for (var entry : levelSums.entrySet()) {
            if (entry.getValue() > highest || (entry.getValue() == highest && entry.getKey() < result)) {
                highest = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}