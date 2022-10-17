class Solution {
    record Elem(long index, long value) {}
    
    private static long MOD = 1000000007;
    
    public int sumSubarrayMins(int[] arr) {
        long[] largerLeft = new long[arr.length];
        long[] largerRight = new long[arr.length];
        Deque<Elem> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && stack.peekLast().value() > arr[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                largerLeft[i] = i + 1;
            } else {
                largerLeft[i] = i - stack.peekLast().index();
            }
            stack.add(new Elem(i, arr[i]));
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peekLast().value() >= arr[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                largerRight[i] = arr.length - i;
            } else {
                largerRight[i] = stack.peekLast().index() - i;
            }
            stack.add(new Elem(i, arr[i]));
        }
        long result = 0;
        for (int i = 0; i < arr.length; ++i) {
            result += arr[i] * largerLeft[i] * largerRight[i];
            result %= MOD;
        }
        return (int)result;
    }
}
