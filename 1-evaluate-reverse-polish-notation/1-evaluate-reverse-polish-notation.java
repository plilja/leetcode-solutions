class Solution {
    private static List<String> OPERATORS = List.of("+", "-", "*", "/");
    
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String token : tokens) {
           if (OPERATORS.contains(token)) {
               int secondOperand = stack.pollLast();
               int firstOperand = stack.pollLast();
               if ("+".equals(token)) {
                   stack.add(firstOperand + secondOperand);
               }
               if ("-".equals(token)) {
                   stack.add(firstOperand - secondOperand);
               }
               if ("/".equals(token)) {
                   stack.add(firstOperand / secondOperand);
               }
               if ("*".equals(token)) {
                   stack.add(firstOperand * secondOperand);
               }
           } else {
               stack.add(Integer.parseInt(token));
           }
        }
        if (stack.isEmpty()) {
            throw new IllegalStateException("No result found");
        } else {
            return stack.pollLast();
        }
           
    }
}
