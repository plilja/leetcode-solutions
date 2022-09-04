class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void partitionHelper(String s, int from, List<String> current, List<List<String>> result) {
        if (s.length() == from) {
            result.add(new ArrayList<>(current));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = from; i < s.length(); ++i) {
                sb.append(s.charAt(i));
                if (isPalindrome(sb)) {
                    current.add(sb.toString());
                    partitionHelper(s, i + 1, current, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(StringBuilder sb) {
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
