class Solution {
    public double angleClock(int hour, int minutes) {
        double hourExact = (hour % 12) + minutes / 60D;
        double angleHour = 360D * (hourExact) / 12D;
        double angleMinute = 360D * minutes / 60D;
        if (angleMinute > angleHour) {
            return Math.min(
                angleMinute - angleHour, 
                angleHour - angleMinute + 360
            );
        } else {
            return Math.min(
                angleHour - angleMinute, 
                angleMinute - angleHour + 360
            );
        }
    }
}