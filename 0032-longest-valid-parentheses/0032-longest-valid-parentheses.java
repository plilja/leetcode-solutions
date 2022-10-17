class Solution {
    public int longestValidParentheses(String s) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
            if (a.from() != b.from()) {
                return a.from() - b.from();
            } else {
                return a.to() - b.to();
            }
        });
        Deque<Integer> leftParen = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParen.add(i);
            } else if (c == ')') {
                if (!leftParen.isEmpty()) {
                    int from = leftParen.pollLast();
                    pq.add(new Interval(from, i));
                }
            } else {
                throw new IllegalArgumentException("Unknown character " + c);
            }
        }
        boolean[] valid = new boolean[s.length()];
        int prevTo = -1;
        while (!pq.isEmpty()) {
            Interval interval = pq.poll();
            if (interval.to() > prevTo) {
                for (int i = Math.max(prevTo, interval.from()); i <= interval.to(); ++i) {
                    valid[i] = true;
                }
                prevTo = interval.to();
            }
        }
        int result = 0;
        int acc = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (valid[i]) {
                acc++;
                result = Math.max(result, acc);
            } else {
                acc = 0;
            }
        }
        return result;
    }
    
    private record Interval(int from, int to) {
    }
}