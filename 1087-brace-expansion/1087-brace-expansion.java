class Solution {
    public String[] expand(String s) {
        TreeSet<String> result = new TreeSet<>();
        List<List<Character>> options = parse(s);
        expand(options, 0, new StringBuilder(), result);
        return result.toArray(new String[]{});
    }
    
    private void expand(List<List<Character>> options, int index, StringBuilder current, TreeSet<String> result) {
        if (index == options.size()) {
            result.add(current.toString());
        } else {
            for (char c : options.get(index)) {
                current.append(c);
                expand(options, index + 1, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    
    private List<List<Character>> parse(String s) {
        List<List<Character>> result = new ArrayList<>();
        int balance = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '{') {
                balance++;
                result.add(new ArrayList<>());
            } else if (c == '}') {
                balance--;
            } else {
                if (balance == 0) {
                    result.add(List.of(c));
                } else {
                    if (c != ',') {
                        var last = result.get(result.size() - 1);
                        last.add(c);
                    }
                }
            }
        }
        return result;
    }
}