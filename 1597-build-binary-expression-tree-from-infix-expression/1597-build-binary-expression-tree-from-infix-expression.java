class Solution {
    public Node expTree(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            q.add(s.charAt(i));
        }
        return parseExpression(q);
    }

    private Node parseExpression(Deque<Character> q) {
        Node right = parseTerm(q);
        if (q.isEmpty() || !List.of('+', '-').contains(q.peekLast())) {
            return right;
        } else {
            char op = q.pollLast();
            Node left = parseExpression(q);
            return new Node(op, left, right);
        }
    }

    private Node parseTerm(Deque<Character> q) {
        Node right = parseFactor(q);
        if (q.isEmpty() || !List.of('*', '/').contains(q.peekLast())) {
            return right;
        } else {
            char op = q.pollLast();
            Node left = parseTerm(q);
            return new Node(op, left, right);
        }
    }

    private Node parseFactor(Deque<Character> q) {
        if (q.peekLast() == ')') {
            q.pollLast(); // consume ')'
            Node expr = parseExpression(q);
            q.pollLast(); // consume '('
            return expr;
        } else {
            char d = q.pollLast();
            return new Node(d);
        }
    }
}
