class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> rightmost = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            rightmost.merge(c, i, (a, b) -> Math.max(a, b));
        }
        List<Integer> result = new ArrayList<>();
        int endSegment = 0;
        int startSegment = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > endSegment) {
                result.add(endSegment - startSegment + 1);
                startSegment = i;
            }
            int index = rightmost.get(s.charAt(i));
            if (index > endSegment) {
                endSegment = index;
            }
        }
        result.add(endSegment - startSegment + 1);
        return result;
    }
}
