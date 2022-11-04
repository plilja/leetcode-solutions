class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] functions = new int[n];
        int prev = 0;
        for (String log : logs) {
            String[] args = log.split(":");
            int functionId = Integer.parseInt(args[0]);
            String startOrEnd = args[1];
            int timestamp = Integer.parseInt(args[2]);
            if ("start".equals(startOrEnd)) {
                if (!stack.isEmpty()) {
                    var last = stack.peekLast();
                    functions[last] += timestamp - prev;
                }
                stack.add(functionId);
                prev = timestamp;
            } else if ("end".equals(startOrEnd)) {
                int expectedFunctionId = stack.pollLast();
                if (functionId != expectedFunctionId) {
                    throw new IllegalArgumentException("FunctionId=%d ended but expected %d".formatted(functionId, expectedFunctionId));
                }
                functions[functionId] += timestamp - prev + 1;
                prev = timestamp + 1;
            } else {
                throw new IllegalArgumentException("Unable to parse log " + log);
            }
        }
        return functions;
    }
}