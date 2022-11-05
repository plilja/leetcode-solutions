class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Long> totalTime = new HashMap<>();
        long prev = 0;
        for (int i = 0; i < keysPressed.length(); ++i) {
            char c = keysPressed.charAt(i);
            long time = releaseTimes[i];
            totalTime.merge(c, time - prev, (a, b) -> Math.max(a, b));
            prev = time;
        }
        double longest = 0;
        char result = '?';
        for (char c : totalTime.keySet()) {
            long duration = totalTime.get(c);
            if (duration > longest || (duration == longest && c > result)) {
                longest = duration;
                result = c;
            }
        }
        return result;
    }
}