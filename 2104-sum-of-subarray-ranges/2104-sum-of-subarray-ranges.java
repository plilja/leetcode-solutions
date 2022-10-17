class Solution {
    record Elem(int index, int value) {}
    
    public long subArrayRanges(int[] nums) {
        long[] leftSmaller = new long[nums.length]; // smaller[i] == num items directly left of i that is smaller or eq to nums[i]
        long[] leftLarger = new long[nums.length];
        long[] rightSmaller = new long[nums.length];
        long[] rightLarger = new long[nums.length];
        Deque<Elem> smaller = new ArrayDeque<>(); 
        Deque<Elem> larger = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            while (!smaller.isEmpty() && smaller.peekLast().value > n) {
                smaller.pollLast();
            }
            if (smaller.isEmpty()) {
                leftSmaller[i] = i + 1;
            } else {
                leftSmaller[i] = i - smaller.peekLast().index();
            }
            
            while (!larger.isEmpty() && larger.peekLast().value < n) {
                larger.pollLast();
            }
            if (larger.isEmpty()) {
                leftLarger[i] = i + 1;
            } else {
                leftLarger[i] = i - larger.peekLast().index();
            }
            smaller.add(new Elem(i, n));
            larger.add(new Elem(i, n));
        }
        smaller.clear();
        larger.clear();
        for (int i = nums.length - 1; i >= 0; --i) {
            int n = nums[i];
            while (!smaller.isEmpty() && smaller.peekLast().value >= n) {
                smaller.pollLast();
            }
            if (smaller.isEmpty()) {
                rightSmaller[i] = nums.length - i;
            } else {
                rightSmaller[i] = smaller.peekLast().index() - i;
            }
            
            while (!larger.isEmpty() && larger.peekLast().value <= n) {
                larger.pollLast();
            }
            if (larger.isEmpty()) {
                rightLarger[i] = nums.length - i;
            } else {
                rightLarger[i] = larger.peekLast().index() - i;
            }
            smaller.add(new Elem(i, n));
            larger.add(new Elem(i, n));
        }
        long result = 0;
        for (int i = 0; i < nums.length; ++i) {
            long n = nums[i];
            result -= n * leftSmaller[i] * rightSmaller[i];
            result += n * leftLarger[i] * rightLarger[i];
        }
        return result;
    }
    
}
