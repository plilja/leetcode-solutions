class Solution {
    public int calculate(String s) {
        return calculateHelper(s, 0, s.length());
    }
    
    private int calculateHelper(String s, int from, int to) {
        Deque<Integer> leftParen = new ArrayDeque<>();
        Deque<String> calcStack = new ArrayDeque<>();
        for (int i = from; i < to; ++i) {
            char c = s.charAt(i);
            if (c == '+') {
                if (leftParen.isEmpty()) {
                    calcStack.add("+");
                }
            } else if (c == '-') {
                if (leftParen.isEmpty()) {
                    if (calcStack.isEmpty()) {
                        calcStack.add("0");
                    }
                    calcStack.add("-");
                }
            } else if (c == '(') {
                leftParen.add(i);
            } else if (c == ')') {
                int j = leftParen.pollLast();
                if (leftParen.isEmpty()) {
                    int v = calculateHelper(s, j + 1, i);
                    calcStack.add(String.valueOf(v));
                }
            } else if (c >= '0' && c <= '9') {
                if (leftParen.isEmpty()) {
                    if (calcStack.isEmpty()) {
                        calcStack.add("" + c);
                    } else {
                        String last = calcStack.peekLast();
                        if (last.charAt(0) >= '0' && last.charAt(0) <= '9') {
                            calcStack.add(calcStack.pollLast() + c);
                        } else {
                            calcStack.add("" + c);
                        }
                    }
                }
            } 
        }
        while (calcStack.size() > 1) {
            int a = Integer.parseInt(calcStack.pollFirst());
            String op = calcStack.pollFirst();
            int b = Integer.parseInt(calcStack.pollFirst());
            if (op.equals("+")) {
                calcStack.addFirst(String.valueOf(a + b));
            } else if (op.equals("-")) {
                calcStack.addFirst(String.valueOf(a - b));
            } else {
                throw new IllegalStateException("Unknown operator type %d %s %d".formatted(a, op, b));
            }
            
        }
        return Integer.parseInt(calcStack.pollLast());
    }
}