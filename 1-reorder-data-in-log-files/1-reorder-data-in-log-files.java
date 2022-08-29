class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            if (isDigitLog(log)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        Collections.sort(letterLogs, (a, b) -> compareLetterLogs(a, b));
        String[] result = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            if (i < letterLogs.size()) {
                result[i] = letterLogs.get(i);
            } else {
                result[i] = digitLogs.get(i - letterLogs.size());
            }
        }
        return result;
    }
    
    private boolean isDigitLog(String log) {
        char last = log.charAt(log.length() - 1);
        return last >= '0' && last <= '9';
    }
    
    private int compareLetterLogs(String logA, String logB) {
        String contentA = getContents2(logA);
        String contentB = getContents2(logB);
        if (!contentA.equals(contentB)) {
            return contentA.compareTo(contentB);
        }
        return getIdentifier2(logA).compareTo(getIdentifier2(logB));
    }
    
    private String getIdentifier2(String log) {
        int index = log.indexOf(" ");
        return log.substring(0, index);
    }
    
    private String getContents2(String log) {
        int index = log.indexOf(" ");
        return log.substring(index + 1);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            boolean log1IsLetterLog = isLetterLog(log1);
            boolean log2IsLetterLog = isLetterLog(log2);
            String log1Identifier = getIdentifier(log1);
            String log2Identifier = getIdentifier(log2);
            String log1Contents = getContents(log1);
            String log2Contents = getContents(log2);
            if (log1IsLetterLog && log2IsLetterLog) {
                if (!log1Contents.equals(log2Contents)) {
                    return log1Contents.compareTo(log2Contents);
                } else {
                    return log1Identifier.compareTo(log2Identifier);
                }
            } else if (log1IsLetterLog) {
                return -1;
            } else if (log2IsLetterLog) {
                return 1;
            } else {
                return 0;
            }
        });
        return logs;
    }
    
    private boolean isLetterLog(String log) {
        for (int i = log.length() - 1; i >= 0; --i) {
            char c = log.charAt(i);
            if (c != ' ') {
                return !Character.isDigit(c);
            }
        }
        return false;
    }
    
    private String getIdentifier(String log) {
        int idx = log.indexOf(' ');
        return log.substring(0, idx);
    }
    
    private String getContents(String log) {
        int idx = log.indexOf(' ');
        return log.substring(idx + 1, log.length());
    }
}
