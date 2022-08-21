import java.util.*;

class Solution {
    private int counter = 0;
    
    record Elem (int value, int counter) implements Comparable<Elem> {
        @Override
        public int compareTo(Elem other) {
            if (value != other.value) {
                return value - other.value;
            } else {
                return counter - other.counter;
            }
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[Math.max(0, nums.length - k + 1)];
        Deque<Elem> sliding = new ArrayDeque<>();
        TreeSet<Elem> slidingElems = new TreeSet<>();
        int i = 0;
        for (int n : nums) {
            Elem elem = new Elem(n, counter++);
            sliding.add(elem);
            slidingElems.add(elem);
            if (sliding.size() > k) {
                var popped = sliding.poll();
                slidingElems.remove(popped);
            }
            if (sliding.size() == k) {
                result[i] = slidingElems.last().value();
                i++;
            }
        }
        return result;
    }
}
