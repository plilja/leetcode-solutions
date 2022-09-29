class Solution {
    public int[] frequencySort(int[] numsArr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : numsArr) {
            freq.merge(n, 1, (a, b) -> a + b);
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numsArr.length; ++i) {
            nums.add(numsArr[i]);
        }
        Collections.sort(nums, (a, b) -> {
            int aCount = freq.get(a);
            int bCount = freq.get(b);
            if (aCount != bCount) {
                return aCount - bCount;
            } else {
                return b - a;
            }
        });
        for (int i = 0; i < numsArr.length; ++i) {
            numsArr[i] = nums.get(i);
        }
        return numsArr;
    }
}