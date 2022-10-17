class Solution {
    public long minimalKSum(int[] numsArr, int k) {
        int[] numsSorted = sortedDistinct(numsArr);
        long result = 0;
        int count = 0;
        long prev = 0;
        for (int n : numsSorted) {
            long countBetween = Math.min(
                Math.max(0, n - prev - 1),
                k - count
            );
            if (countBetween > 0) {
                count += countBetween;
                result += calcSumBetween(prev + 1, prev + countBetween);
            }
            prev = n;
            if (count == k) {
                break;
            }
        }
        if (count < k) {
            int rem = k - count;
            result += calcSumBetween(numsSorted[numsSorted.length - 1] + 1, numsSorted[numsSorted.length - 1] + rem);
            count = k;
        }
        return result;
    }
    
    private int[] sortedDistinct(int[] arr) {
        HashSet<Integer> nums = new HashSet<>();
        for (int n : arr) {
            nums.add(n);
        }
        int[] result = new int[nums.size()];
        int i = 0;
        for (int n : nums) {
            result[i] = n;
            i++;
        }
        Arrays.sort(result);
        return result;
    }
    
    private long calcSumBetween(long a, long b) {
        if ((b - a) % 2 == 1) {
            /*
            0,1
            0,1,2,3
            */
            long count = (b - a + 1) / 2;
            return count * (b + a);
        } else {
            /*
            0,1,2
            */
            long count = (b - a) / 2;
            long middle = a + (b - a) / 2;
            return count * (b + a) + middle;
        }
    }
}
