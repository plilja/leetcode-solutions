class Solution {
    public int countTime(String time) {
        int i = time.indexOf('?'); 
        if (i != -1) {
            int result = 0;
            for (int j = 0; j <= 9; ++j) {
                String sub = time.substring(0, i) + String.valueOf(j) + time.substring(i + 1, time.length());
                result += countTime(sub);
            }
            return result;
        } else {
            if (isValid(time)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    private boolean isValid(String time) {
        String[] args = time.split(":");
        int hh = Integer.parseInt(args[0]);
        int mm = Integer.parseInt(args[1]);
        return 0 <= hh && hh <= 23 && 00 <= mm && mm <= 59;
    }
}