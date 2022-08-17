/**
[1,3,-1,-3,5,3,6,7]
[1,3,-1]
[3,-1,-3]
[-1,-3,5]
[-3,5,3]
[5,3,6]
[3,6,7]
*/
import java.util.*;

class Solution {
    record Val (double value, String uuid) implements Comparable<Val> {
        Val(double value) {
            this(value, UUID.randomUUID().toString());
        }
        
        @Override
        public int compareTo(Val other) {
            if (value != other.value) {
                return (int) Math.signum(value - other.value());
            } else {
                return uuid.compareTo(other.uuid());
            }
        }
    }
    
    class SlidingWindowMedian {
        private final Deque<Val> slidingNumbers = new ArrayDeque<>();
        private final TreeSet<Val> left = new TreeSet<>();
        private final TreeSet<Val> right = new TreeSet<>();
        private final int k;
        
        public SlidingWindowMedian(int k) {
            this.k = k;
        }
        
        void add(int value) {
            if (slidingNumbers.size() == k) {
                Val remove = slidingNumbers.poll();
                left.remove(remove);
                right.remove(remove);
            }
            Val val = new Val((double)value);
            slidingNumbers.add(val);
            if (left.isEmpty() || value <= left.last().value()) {
                left.add(val);
            } else {
                right.add(val);
            }
            if (slidingNumbers.size() == k) {
                while (left.size() < right.size()) {
                    Val rightMin = right.first();
                    right.remove(rightMin);
                    left.add(rightMin);
                }
                int rightDiff = k % 2 == 0 ? 0 : 1;
                while (left.size() > right.size() + rightDiff) {
                    Val leftMax = left.last();
                    left.remove(leftMax);
                    right.add(leftMax);
                }
            }
        }
        
        double median() {
            if (k % 2 == 0) {
                var l2 = left;
                var r2 = right;
                Val leftMax = left.last();
                Val rightMin = right.first();
                return (leftMax.value() + rightMin.value()) / 2D;
            } else {
                var foo = left;
                var bar = left.last();
                return (double) left.last().value();
            }
        }
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian(k);
        for (int i = 0; i < k - 1; ++i) {
            slidingWindowMedian.add(nums[i]);
        }
        double[] result = new double[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; ++i) {
            slidingWindowMedian.add(nums[i]);
            result[i - k + 1] = slidingWindowMedian.median();
        }
        return result;
    }
}
