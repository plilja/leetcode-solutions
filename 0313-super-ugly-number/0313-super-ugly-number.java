import java.math.BigInteger;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        TreeSet<Long> nums = new TreeSet<>();
        TreeSet<Long> prev = new TreeSet<>();
        nums.add(1L);
        prev.add(1L);
        while (prev.size() > 0) {
            TreeSet<Long> newPrev = new TreeSet<>();
            for (long prime : primes) {
                for (long p : prev) {
                    long product = p*prime;
                    if ((nums.size() < n || nums.last().compareTo(product) > 0) && product <= Integer.MAX_VALUE) {
                        if (!nums.contains(product)) {
                            newPrev.add(product);
                            nums.add(product);
                        }
                    } else {
                        break;
                    }
                }
            }
            while (nums.size() > n) {
                nums.remove(nums.last());
            }
            prev = newPrev;
        }
        return nums.last().intValue();
    }
}