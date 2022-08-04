class Logger {
    private final Map<String, Integer> lastTimestampForMessage = new HashMap<>();

    public Logger() {
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTimestamp = lastTimestampForMessage.get(message);
        boolean result = lastTimestamp == null || (lastTimestamp + 10 <= timestamp);
        if (result) {
            lastTimestampForMessage.put(message, timestamp);
        }
        return result;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
