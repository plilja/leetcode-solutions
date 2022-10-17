class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        for (String s : strings) {
            boolean match = false;
            for (List<String> group : result) {
                String inGroup = group.get(0);
                if (sameShiftGroup(inGroup, s)) {
                    group.add(s);
                    match = true;
                    break;
                }
            }
            if (!match) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                result.add(newGroup);
            }
        }
        return result;
    }
    
    private boolean sameShiftGroup(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.length() == 0 && b.length() == 0) {
            return true;
        }
        int maxDist = (int) ('z' - 'a') + 1;
        int firstDist = mod((int) (a.charAt(0) - b.charAt(0)), maxDist);
        for (int i = 1; i < a.length(); ++i) {
            int dist = mod((int) (a.charAt(i) - b.charAt(i)), maxDist);
            if (firstDist != dist) {
                return false;
            }
        }
        return true;
    }
    
    private int mod(int n, int m) {
        while (n < 0) {
            n += m;
        }
        return n % m;
    }
}
