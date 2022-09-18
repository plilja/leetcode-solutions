class Solution {
    public int calculate(String s) {
       var tokens1 = tokenize(s);
       var tokens2 = evalMulDiv(tokens1);
       var tokens3 = evalSubAdd(tokens2);
       return Integer.parseInt(tokens3.get(0));
    }
    
    private List<String> evalMulDiv(List<String> tokens) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);
            if ("/".equals(token)) {
                int last = Integer.parseInt(result.get(result.size() - 1));
                int next = Integer.parseInt(tokens.get(i + 1));
                result.set(result.size() - 1, String.valueOf(last / next));
                i += 2;
            } else if ("*".equals(token)) {
                int last = Integer.parseInt(result.get(result.size() - 1));
                int next = Integer.parseInt(tokens.get(i + 1));
                result.set(result.size() - 1, String.valueOf(last * next));
                i += 2;
            } else {
                result.add(token);
                i++;
            }
        }
        return result;
    }
    
    private List<String> evalSubAdd(List<String> tokens) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);
            if ("-".equals(token)) {
                int last = Integer.parseInt(result.get(result.size() - 1));
                int next = Integer.parseInt(tokens.get(i + 1));
                result.set(result.size() - 1, String.valueOf(last - next));
                i += 2;
            } else if ("+".equals(token)) {
                int last = Integer.parseInt(result.get(result.size() - 1));
                int next = Integer.parseInt(tokens.get(i + 1));
                result.set(result.size() - 1, String.valueOf(last + next));
                i += 2;
            } else {
                result.add(token);
                i++;
            }
        }
        return result;
    }

    private List<String> tokenize(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (isDigit(c)) {
                if (result.isEmpty() || !isDigit(result.get(result.size() - 1).charAt(0))) {
                    result.add("" + c);
                } else {
                    result.set(result.size() - 1, result.get(result.size() - 1) + c);
                }
            } else if (c == '*') {
                result.add("*");
            } else if (c == '-') {
                result.add("-");
            } else if (c == '+') {
                result.add("+");
            } else {
                if (c != '/') {
                    throw new IllegalArgumentException("Unknown character " + c + " encountered");
                }
                result.add("/");
            }
        }
        return result;
    }
    
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
