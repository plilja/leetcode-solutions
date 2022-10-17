class Solution {
    public long maximumBooks(int[] books) {
        // dp[i] == max books you can take between 0 and i shelf where you take from shelf i
        long[] dp = new long[books.length]; 
        Deque<Elem> stack = new ArrayDeque<>();
        for (int i = 0; i < books.length; ++i) {
            long shelf = books[i];
            while (!stack.isEmpty()) {
                Elem top = stack.peekLast();
                if (top.value() + i - top.index() >= shelf) {
                    stack.pollLast();
                } else {
                    break;
                }
            }
            if (shelf != 0) {
                if (stack.isEmpty()) {
                    dp[i] = count(shelf, Math.min(shelf, i + 1));
                } else {
                    Elem top = stack.peekLast();
                    dp[i] = count(shelf, Math.min(shelf, i - top.index()));
                    dp[i] += dp[top.index()];
                }
            }
            stack.add(new Elem(i, shelf));
        }
        long result = 0;
        for (int i = 0; i < books.length; ++i) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    
    private long count(long n, long k) {
        long result = 0;
        if (k % 2 == 0) {
            result = (2 * n - k + 1) * (k / 2);
        } else {
            result = n + count(n - 1, k - 1);
        }
        return result;
    }
    
    private record Elem (int index, long value) {
    }
}
