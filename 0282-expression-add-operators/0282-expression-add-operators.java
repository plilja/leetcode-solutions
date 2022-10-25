class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void helper(String num, long target, int i, List<String> current, List<String> result) {
        if (i == num.length()) {
            List<Long> sums = new ArrayList<>();
            long currentSign = 1;
            int j = 0;
            while (j < current.size()) {
                String op = current.get(j);
                if ("-".equals(op)) {
                    currentSign = -1;
                    j++;
                } else if ("+".equals(op)) {
                    currentSign = 1;
                    j++;
                } else if ("*".equals(op)) {
                    long last = sums.get(sums.size() - 1);
                    long next = Long.parseLong(current.get(j + 1));
                    sums.set(sums.size() - 1, last * next);
                    j += 2;
                } else {
                    long n = Long.parseLong(op);
                    sums.add(currentSign * n);
                    j++;
                }
            }
            long total = 0;
            for (long n : sums) {
                total += n;
            }
            if (total == target) {
                StringBuilder sb = new StringBuilder();
                for (String op : current) {
                    sb.append(op);
                }
                result.add(sb.toString());
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < num.length() - 1; ++j) {
                char c = num.charAt(j);
                sb.append(c);
                if (sb.charAt(0) == '0' && sb.length() > 1) {
                    break;
                }
                
                current.add(sb.toString());
                
                current.add("-");
                helper(num, target, j + 1, current, result);
                current.remove(current.size() - 1);
                
                current.add("+");
                helper(num, target, j + 1, current, result);
                current.remove(current.size() - 1);
                
                current.add("*");
                helper(num, target, j + 1, current, result);
                current.remove(current.size() - 1);
                
                current.remove(current.size() - 1);
            }
            
            sb.append(num.charAt(num.length() - 1));
            if (sb.length() == 1 || sb.charAt(0) != '0') {
                current.add(sb.toString());
                helper(num, target, num.length(), current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}