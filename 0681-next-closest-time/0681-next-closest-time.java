class Solution {
    public String nextClosestTime(String time) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < time.length(); ++i) {
            char c = time.charAt(i);
            if (c != ':') {
                chars.add(c);
            }
        }
        String result = null;
        List<String> allTimes = new ArrayList<>();
        generateAllTimes(new StringBuilder(), chars, allTimes);
        allTimes.sort((a, b) -> getMinutesFromMidnight(a) - getMinutesFromMidnight(b));
        for (String otherTime : allTimes) {
            if (getMinutesFromMidnight(time) < getMinutesFromMidnight(otherTime)) {
                result = otherTime;
                break;
            }
        }
        if (result == null) {
            return allTimes.get(0);
        } else {
            return result;
        }
    }
    
    private int getMinutesFromMidnight(String time) {
        String[] args = time.split(":");
        int hh = Integer.parseInt(args[0]);
        int mm = Integer.parseInt(args[1]);
        return hh * 60 + mm;
    }
    
    private void generateAllTimes(StringBuilder current, Set<Character> chars, List<String> result) {
        if (current.length() == 4) {
            String s = current.toString();
            String time = s.substring(0, 2) + ":" + s.substring(2, 4);
            if (isValid(time)) {
                result.add(time);
            }
        } else {
            for (char c : chars) {
                current.append(c);
                generateAllTimes(current, chars, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    
    private boolean isValid(String time) {
        if (time.length() != 5 || time.indexOf(':') == -1) {
            return false;
        }
        String[] args = time.split(":");
        int hh = Integer.parseInt(args[0]);
        int mm = Integer.parseInt(args[1]);
        return hh >= 0 && hh <= 23 && mm >= 0 && mm <= 59;
    }
}