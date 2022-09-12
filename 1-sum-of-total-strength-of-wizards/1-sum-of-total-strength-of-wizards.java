class Solution {
    private static int MOD = 1000000007;
    
    public int totalStrength(int[] strengthsInts) {
        long[] strengths = toLongs(strengthsInts);
        long[] preSums = calcPrefixSums(strengths);
        long[] prePreSums = calcPrefixSums(preSums);
        int[] minLefts = calcMinLefts(strengths);
        int[] minRights = calcMinRights(strengths);
        long result = 0;
        for (int i = 0; i < strengths.length; ++i) {
            long strength = strengths[i];
            int left = minLefts[i];
            int right = minRights[i];
            long sum = left * (get(prePreSums, i + right - 1) - get(prePreSums, i - 1)) - right * (get(prePreSums, i - 1) - get(prePreSums, i - left -1));
            while (sum < 0) {
                sum += MOD;
            }
            sum %= MOD;
            long sub = strength * sum;
            sub %= MOD;
            result += sub;
            result %= MOD;
        }
        return (int)result;
    }
    
    private long[] toLongs(int[] arr) {
        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }
    
    private long get(long[] values, int index) {
        if (index < 0) {
            return 0;
        } else if (index >= values.length) {
            return 0;
        } else {
            return values[index];
        }
    }
    
    private long[] calcPrefixSums(long[] values) {
        long acc = 0;
        long[] result = new long[values.length];
        for (int i = 0; i < values.length; ++i) {
            acc += values[i];
            acc %= MOD;
            result[i] = acc;
        }
        return result;
    }
    
    private int[] calcMinLefts(long[] strengths) {
        Deque<Item> stack = new ArrayDeque<>();
        int[] result = new int[strengths.length];
        for (int i = 0; i < strengths.length; ++i) {
            long strength = strengths[i];
            while (!stack.isEmpty() && stack.peekLast().value() > strength) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peekLast().index();
            }
            stack.add(new Item(i, strength));
        }
        return result;
    }
    
    private int[] calcMinRights(long[] strengths) {
        Deque<Item> stack = new ArrayDeque<>();
        int[] result = new int[strengths.length];
        for (int i = strengths.length - 1; i >= 0; --i) {
            long strength = strengths[i];
            while (!stack.isEmpty() && stack.peekLast().value() >= strength) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                result[i] = strengths.length - i;
            } else {
                result[i] = stack.peekLast().index() - i;
            }
            stack.add(new Item(i, strength));
        }
        return result;
    }
    
    record Item (int index, long value) {}
}
