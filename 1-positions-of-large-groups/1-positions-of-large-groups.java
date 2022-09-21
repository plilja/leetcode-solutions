class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c1 = s.charAt(i);
            int count = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                char c2 = s.charAt(j);
                if (c1 != c2) {
                    break;
                }
                count++;
            }
            if (count >= 3) {
                result.add(List.of(i, i + count - 1));
            }
            i += count;
        }
        return result;
    }
}
