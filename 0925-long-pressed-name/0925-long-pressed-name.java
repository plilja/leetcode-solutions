class Solution {
    public boolean isLongPressedName(String name, String typed) {
        var groupsName = groups(name);
        var groupsTyped = groups(typed);
        if (groupsName.size() != groupsTyped.size()) {
            return false;
        }
        for (int i = 0; i < groupsName.size(); ++i) {
            if (groupsName.get(i).size() > groupsTyped.get(i).size()) {
                return false;
            }
            if (groupsName.get(i).get(0) != groupsTyped.get(i).get(0)) {
                return false;
            }
        }
        return true;
    }
    
    private List<List<Character>> groups(String s) {
        List<List<Character>> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(s.charAt(i));
        }
        return result;
    }
}