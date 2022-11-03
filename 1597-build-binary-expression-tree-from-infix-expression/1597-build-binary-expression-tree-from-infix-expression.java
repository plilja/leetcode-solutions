/*
Grammar:

expr = term | add | sub
sub = expr - term
add = expr + term
term = operator | mul | div
mul = term * operator
div = term / operator
operator = number | '(' + expr + ')'
number = '0' - '9'

*/
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
        boolean isAddOrSub = !q.isEmpty() && List.of('+', '-').contains(q.peekLast());
        if (isAddOrSub) {
            char op = q.pollLast();
            Node left = parseExpression(q);
            return new Node(op, left, right);
        } else {
            return right;
        }
    }

    private Node parseTerm(Deque<Character> q) {
        Node right = parseFactor(q);
        boolean isMulOrDiv = !q.isEmpty() && List.of('*', '/').contains(q.peekLast());
        if (isMulOrDiv) {
            char op = q.pollLast();
            Node left = parseTerm(q);
            return new Node(op, left, right);
        } else {
            return right;
        }
    }

    private Node parseFactor(Deque<Character> q) {
        boolean isParenExpr = q.peekLast() == ')';
        if (isParenExpr) {
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