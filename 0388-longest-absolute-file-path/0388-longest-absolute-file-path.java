class Solution {
    public int lengthLongestPath(String input) {
        String[] args = input.split("\\n");
        Deque<Integer> stack = new ArrayDeque<>();
        int prevDepth = -1;
        int currLen = 0;
        int result = 0;
        for (String arg : args) {
            int countTabs = arg.lastIndexOf('\t') + 1;
            for (int i = 0; i < Math.max(0, prevDepth - countTabs + 1); ++i) {
                int len = stack.pollLast();
                currLen -= len;
            }
            String name = arg.substring(countTabs);
            if (name.indexOf('.') != -1) {
                // file
                result = Math.max(result, currLen + name.length() + stack.size());
            }
            currLen += name.length();
            stack.add(name.length());
            prevDepth = countTabs;
        }
        return result;
    }
}
