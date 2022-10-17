class Solution {
    public String fractionToDecimal(int num, int den) {
        return helper(num, den);
    }
    
    private String helper(long num, long den) {
        if (num == 0) {
            return "0";
        }
        if (num < 0 && den < 0) {
            return helper(-num, -den);
        }
        if (num < 0 || den < 0) {
            return "-" + helper(Math.abs(num), Math.abs(den));
        }
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(num / den));
        if (num % den != 0) {
            Map<Long, Integer> rems = new HashMap<>();
            result.append(".");
            long rem = 10L * (num % den);
            while (rem != 0) {
                if (rems.containsKey(rem)) {
                    int i = rems.get(rem);
                    String start = result.substring(0, i);
                    String repeating = result.substring(i, result.length());
                    return start + "(" + repeating + ")";
                }
                rems.put(rem, result.length());
                long div = rem / den;
                result.append(div);
                rem = 10L * (rem % den);
            }
        }
        return result.toString();
    }
}