class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression);
        return new ArrayList<>(new TreeSet<>(result));
    }
    
    private Set<String> solve(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Set<String>>> parts = new ArrayList<>();
        parts.add(new ArrayList<>());
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == '{') {
                stack.add(i);
            } else if (c == '}') {
                int start = stack.pollLast() + 1;
                if (stack.isEmpty()) {
                    int end = i;
                    String subExpression = expression.substring(start, end);
                    Set<String> sub = solve(subExpression);
                    parts.get(parts.size() - 1).add(sub);
                }
            } else if (c == ',') {
                if (stack.isEmpty()) {
                    parts.add(new ArrayList<>());
                }
            } else {
                if (c < 'a' || c > 'z') {
                    throw new IllegalArgumentException("Unknown token " + c + " encountered");
                }
                if (stack.isEmpty()) {
                    parts.get(parts.size() - 1).add(Set.of("" + c));
                }
            }
        }
        Set<String> result = new HashSet<>();
        for (List<Set<String>> part : parts) {
            result.addAll(combinations(part, 0));
        }
        return result;
    }
    
    private Set<String> combinations(List<Set<String>> part, int index) {
        if (index == part.size()) {
            return Set.of("");
        } else {
            Set<String> first = part.get(index);
            Set<String> result = new HashSet<>();
            for (String sub : combinations(part, index + 1)) {
                for (String w : first) {
                    result.add(w + sub);
                }
            }
            return result;
        }
    }
}
