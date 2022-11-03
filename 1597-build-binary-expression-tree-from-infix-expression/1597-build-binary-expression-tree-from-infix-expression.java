class Solution {
    public Node expTree(String s) {
        List<Node> nodes = exprList(s);
        List<Node> plusMinus = evalOperators(nodes, Set.of('*', '/'));
        List<Node> result = evalOperators(plusMinus, Set.of('+', '-'));
        return result.get(0);
    }
    
    private List<Node> evalOperators(List<Node> nodes, Set<Character> operators) {
        List<Node> result = new ArrayList<>();
        int i = 0;
        while (i < nodes.size()) {
            Node node = nodes.get(i);
            boolean isLeaf = node.left == null && node.right == null;
            if (isLeaf && operators.contains(node.val)) {
                Node last = result.get(result.size() - 1);
                Node next = nodes.get(i + 1);
                node.left = last;
                node.right = next;
                result.set(result.size() - 1, node);
                i += 2;
            } else {
                result.add(node);
                i++;
            }
        }
        return result;
    }
    
    private List<Node> exprList(String s) {
        Deque<Integer> leftParen = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParen.add(i);
            } else if (c == ')') {
                int j = leftParen.pollLast();
                if (leftParen.isEmpty()) {
                    Node node = expTree(s.substring(j + 1, i));
                    list.add(node);
                }
            } else if (leftParen.isEmpty()) {
                list.add(new Node(c));
            }
        }
        return list;
    }
}