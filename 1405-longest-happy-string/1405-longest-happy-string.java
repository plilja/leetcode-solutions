class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('a', a);
        counts.put('b', b);
        counts.put('c', c);
        StringBuilder result = new StringBuilder();
        while (true) {
            char last = getLast(result);
            char secondLast = getSecondToLast(result);
            int largestValue = -1;
            char largestKey = '?';
            for (var entry : counts.entrySet()) {
                if (last == entry.getKey() && last == secondLast) {
                    continue; // cannot append a third identical char
                }
                if (largestValue < entry.getValue()) {
                    largestKey = entry.getKey();
                    largestValue = entry.getValue();
                }
            }
            if (largestValue <= 0) {
                break;
            }
            result.append(largestKey);
            counts.put(largestKey, largestValue - 1);
        }
        return result.toString();
    }
    
    private char getLast(StringBuilder sb) {
        if (sb.length() == 0) {
            return '?';
        } else {
            return sb.charAt(sb.length() - 1);
        }
    }
    
    private char getSecondToLast(StringBuilder sb) {
        if (sb.length() <= 1) {
            return '?';
        } else {
            return sb.charAt(sb.length() - 2);
        }
    }
}