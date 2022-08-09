/*

[odd, even, odd, even, odd, even, ...]
[0, 3, 1, 7, 2, 5, -, -, 3, -, 6 , - , - , - , - , - ,  4]
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
*/
class Solution {
    record Item(
        int idx,
        int value
    ) {
    }
    
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        List<Item> powers = new ArrayList<>();
        for (int i = lo; i <= hi; ++i) {
            powers.add(new Item(i, powerValue(i, cache)));
        }
        Collections.sort(powers, (a, b) -> a.value() - b.value());
        return powers.get(k - 1).idx();
        
    }
    
    private int powerValue(int n, Map<Integer, Integer> cache) {
        if (n == 1) {
            return 0;
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else if (n % 2 == 0) {
            int ans = powerValue(n / 2, cache) + 1;
            cache.put(n, ans);
            return ans;
        } else {
            int ans = powerValue(3 * n + 1, cache) + 1;
            cache.put(n, ans);
            return ans;
        }
    }
}
