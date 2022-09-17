class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Set<Character> distinctS = new HashSet<>();
        List<Integer> nonMatches = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = goal.charAt(i);
            if (c1 != c2) {
                nonMatches.add(i);
            }
            distinctS.add(c1);
        }
        if (nonMatches.isEmpty()) {
            return distinctS.size() != s.length();
        }
        if (nonMatches.size() != 2) {
            return false;
        }
        int i = nonMatches.get(0);
        int j = nonMatches.get(1);
        if (s.charAt(i) != goal.charAt(j) || s.charAt(j) != goal.charAt(i)) {
            return false;
        }
        return true;
    }
}
