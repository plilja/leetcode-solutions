class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 1023; ++i) {
            if (numBits(i) == turnedOn) {
                int hours = getHours(i);
                int minutes = getMinutes(i);
                if (hours <= 11 && minutes <= 59) {
                    if (minutes < 10) {
                        result.add("%d:0%d".formatted(hours, minutes));
                    } else {
                        result.add("%d:%d".formatted(hours, minutes));
                    }
                }
            }
        }
        return result;
    }
    
    private int getHours(int n) {
        return (n >> 6) & 15;
    }
    
    private int getMinutes(int n) {
        return n & 63;
    }
    
    private int numBits(int n) {
        int result = 0;
        int current = n;
        while (current > 0) {
            if ((current & 1) != 0) {
                result++;
            }
            current >>= 1;
        }
        return result;
    }
}
