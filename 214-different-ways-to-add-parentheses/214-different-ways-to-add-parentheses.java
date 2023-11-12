class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        String exprWithSpaces = expression
                .replace("*", " * ")
                .replace("-", " - ")
                .replace("+", " + ");
        String[] args = exprWithSpaces.split(" ");
        return solve(args, 0, args.length);
    }

    private List<Integer> solve(String[] args, int left, int right) {
        if (right - left == 1) {
            return List.of(Integer.parseInt(args[left]));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left + 1; i < right - 1; i++) {
            if (List.of("+", "-", "*").contains(args[i])) {
                List<Integer> leftPossibilities = solve(args, left, i);
                List<Integer> rightPossibilities = solve(args, i + 1, right);
                for (int a : leftPossibilities) {
                    for (int b : rightPossibilities) {
                        if (args[i].equals("+")) {
                            result.add(a + b);
                        } else if (args[i].equals("-")) {
                            result.add(a - b);
                        } else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }
        return result;
    }
}
