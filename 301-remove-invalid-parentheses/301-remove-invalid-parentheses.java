class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        helper(s, 0, new StringBuilder(), 0, new AtomicInteger(s.length() + 1), result);
        return new ArrayList<>(result);
    }
    
    private void helper(String s, int i, StringBuilder current, int removals, AtomicInteger best, Set<String> result) {
        if (removals > best.get()) {
            return;
        } else if (i == s.length()) {
            if (isValid(current.toString())) {
                if (removals < best.get()) {
                    best.set(removals);
                    result.clear();
                }
                if (removals == best.get()) {
                    result.add(current.toString());
                }
            }
        } else {
            char c = s.charAt(i);
            current.append(c);
            helper(s, i + 1, current, removals, best, result);
            current.deleteCharAt(current.length() - 1);
            if (c == '(' || c == ')') {
                helper(s, i + 1, current, removals + 1, best, result);
            }
        }
    }
    
    private boolean isValid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}