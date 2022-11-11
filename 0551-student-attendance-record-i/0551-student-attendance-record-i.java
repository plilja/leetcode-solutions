class Solution {
    public boolean checkRecord(String s) {
        int absentDays = 0;
        int consecLate = 0;
        boolean threeDaysLate = false;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentDays++;
                consecLate = 0;
            } else if (c == 'L') {
                consecLate++;
                if (consecLate >= 3) {
                    threeDaysLate = true;
                }
            } else {
                consecLate = 0;
            }
        }
        return absentDays < 2 && !threeDaysLate;
        
    }
}