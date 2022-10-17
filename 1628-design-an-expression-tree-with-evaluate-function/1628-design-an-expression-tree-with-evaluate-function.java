/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class Constant extends Node {
    private final int value;
    
    public Constant(int value) {
        this.value = value;
    }
    
    @Override
    public int evaluate() {
        return value;
    }
}

class Operand extends Node {
    private final Node left;
    private final Node right;
    private final BiFunction<Integer, Integer, Integer> operation;
    
    Operand(Node left, Node right, BiFunction<Integer, Integer, Integer> operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }
    
    @Override
    public int evaluate() {
        return operation.apply(left.evaluate(), right.evaluate());
    }
}
    
class Multiplication extends Operand {
    Multiplication(Node left, Node right) {
        super(left, right, (a, b) -> a * b);
    }
}

class Addition extends Operand {
    Addition(Node left, Node right) {
        super(left, right, (a, b) -> a + b);
    }
}

class Subtraction extends Operand {
    Subtraction(Node left, Node right) {
        super(left, right, (a, b) -> a - b);
    }
}

class Division extends Operand {
    Division(Node left, Node right) {
        super(left, right, (a, b) -> a / b);
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        for (String arg : postfix) {
            if ("*".equals(arg)) {
                Node right = stack.pollLast();
                Node left = stack.pollLast();
                stack.add(new Multiplication(left, right));
            } else if ("+".equals(arg)) {
                Node right = stack.pollLast();
                Node left = stack.pollLast();
                stack.add(new Addition(left, right));
            } else if ("-".equals(arg)) {
                Node right = stack.pollLast();
                Node left = stack.pollLast();
                stack.add(new Subtraction(left, right));
            } else if ("/".equals(arg)) {
                Node right = stack.pollLast();
                Node left = stack.pollLast();
                stack.add(new Division(left, right));
            } else {
                Integer value = Integer.parseInt(arg);
                stack.add(new Constant(value));
            }
        }
        return stack.pollLast();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
