class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(0, s, 0, new HashMap<>());
    }
    
    private boolean checkValidString(int count, String s, int start, Map<Integer, Map<Integer, Boolean>> cache) {
        if (start == s.length()) {
            return count == 0;
        }
        Boolean cached = cache.computeIfAbsent(start, k -> new HashMap<>()).get(count);
        if (cached != null) {
            return cached;
        }
        
        boolean result;
        char c = s.charAt(start);
        if (c == '(') {
            result = checkValidString(count + 1, s, start + 1, cache);
        } else if (c == ')') {
            if (count == 0) {
                result = false;
            } else {
                result = checkValidString(count - 1, s, start + 1, cache);
            }
        } else {
            if (c != '*') {
                throw new IllegalArgumentException("unknown char encountered " + c);
            }
            if (count > 0 && checkValidString(count - 1, s, start + 1, cache)) {
                result = true;
            } else if (checkValidString(count + 1, s, start + 1, cache)) {
                result = true;
            } else {
                result = checkValidString(count, s, start + 1, cache);
            }
        }
        cache.get(start).put(count, result);
        return result;
    }
}
