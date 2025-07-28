class Solution {
    public int reversePairs(int[] nums) {
        return solveAndSort(nums, 0, nums.length);
    }

    private int solveAndSort(int[] nums, int from, int to) {
        if (from >= to - 1) {
            return 0;
        }
        int middle = (to + from) / 2;
        int result = 0;
        result += solveAndSort(nums, from, middle);
        result += solveAndSort(nums, middle, to);
        result += countPairs(nums, from, middle, middle, to);
        mergeSorted(nums, from, to, middle);
        return result;
    }

    private int countPairs(int[] nums, int from1, int to1, int from2, int to2) {
        int result = 0;
        int pointer = from2;
        for (int i = from1; i < to1; i++) {
            long a = nums[i];
            while (pointer < to2) {
                long b = nums[pointer];
                if (a <= 2 * b) {
                    break;
                }
                pointer++;
            }
            result += pointer - from2;
        }
        return result;
    }

    private void mergeSorted(int[] nums, int from, int to, int middle) {
        ArrayList<Integer> result = new ArrayList<>();
        int a = from;
        int b = middle;
        while (a < middle || b < to) {
            if (a == middle) {
                result.add(nums[b]);
                b++;
            } else if (b == to) {
                result.add(nums[a]);
                a++;
            } else if (nums[a] < nums[b]) {
                result.add(nums[a]);
                a++;
            } else {
                result.add(nums[b]);
                b++;
            }
        }
        for (int i = from; i < to; i++) {
            nums[i] = result.get(i - from);
        }
    }
}

