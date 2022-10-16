import java.math.*;

class Solution {
    private static final BigInteger MOD = BigInteger.valueOf(1000000007);
    
    public int[] productQueries(int n, int[][] queries) {
        List<Long> powers = new ArrayList<>();
        int r = n;
        long power = 1;
        while (r != 0) {
            if ((r & 1) != 0) {
                powers.add(power);
            }
            r >>= 1;
            power *= 2;
        }
        List<BigInteger> prefixMult = new ArrayList<>();
        for (int i = 0; i < powers.size(); ++i) {
            long p = powers.get(i);
            if (prefixMult.isEmpty()) {
                prefixMult.add(BigInteger.valueOf(p));
            } else {
                prefixMult.add(prefixMult.get(prefixMult.size() - 1).multiply(BigInteger.valueOf(p)));
            }
        }
        System.out.println(powers);
        System.out.println(prefixMult);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            BigInteger ans = prefixMult.get(right);
            if (left > 0) {
                ans = ans.divide(prefixMult.get(left - 1));
            }
            result[i] = ans.mod(MOD).intValue();
        }
        return result;
    }
}