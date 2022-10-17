class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }
    
    private void generateParenthesis(List<String> result, String expr, int left, int right) {
        if (right == 0 && left == 0) {
            result.add(expr);
        }
        if (left > 0) {
            generateParenthesis(result, expr + "(", left - 1, right);
        }
        if (left < right) {
            generateParenthesis(result, expr + ")", left, right - 1);
        }
    }
}
