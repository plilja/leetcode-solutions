/*
[1, 1, 3, 5, 6]
(1, 1)
(1, 3)
(1, 5)
(1, 6)
(1, 3)
(1, 5)
(1, 6)
(3, 5)
(3, 6)
(5, 6)
*/
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int maxDist = nums[nums.length - 1] - nums[0];
        int a = 0;
        int b = maxDist;
        while (a < b) {
            int middle = a + (b - a) / 2;
            
            AtomicInteger closestSmallerThan = new AtomicInteger();
            int numSmaller = countPairsSmallerEqThan(nums, middle, closestSmallerThan);
            if (numSmaller == k) {
                return closestSmallerThan.get();
            } else if (numSmaller < k) {
                a = middle + 1;
            } else {
                b = middle - 1;
            }
        }
        if (countPairsSmallerEqThan(nums, a, new AtomicInteger()) >= k) {
            return a;
        } else {
            return a + 1;
        }
    }
    
    private int countPairsSmallerEqThan(int[] nums, int value, AtomicInteger closestSmallerThan) {
        int numSmaller = 0;
        closestSmallerThan.set(Integer.MIN_VALUE);
        int left = nums.length - 1;
        int right = nums.length - 1;
        while (right >= 1) {
            while (left > 0 && nums[right] - nums[left - 1] <= value) {
                left--;
            }
            int count = right - left;
            numSmaller += count;
            closestSmallerThan.set(Math.max(closestSmallerThan.get(), nums[right] - nums[left]));
            right--;
        }
        return numSmaller;
    }
    
    public int smallestDistancePair2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                int b = nums[j];
                result.add(Math.abs(a - b));
            }
        }
        Collections.sort(result);
        return result.get(k - 1);
    }
}
