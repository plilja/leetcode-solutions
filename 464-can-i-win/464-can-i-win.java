class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        BitSet choosable = new BitSet();
        int sum = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            choosable.set(i, true);
            sum += i;
        }
        if (sum < desiredTotal) {
            return false; // no one can win
        }
        return helper(new HashMap<>(), choosable, desiredTotal);
    }

    private boolean helper(Map<CacheKey, Boolean> cache, BitSet choosable, int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        CacheKey cacheKey = new CacheKey(choosable, desiredTotal);
        Boolean cached = cache.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        for (int i = 1; i < choosable.length(); i++) {
            if (choosable.get(i)) {
                choosable.set(i, false);
                boolean b = helper(cache, choosable, desiredTotal - i);
                choosable.set(i, true);
                if (!b) {
                    cache.put(cacheKey, true);
                    return true;
                }
            }
        }
        cache.put(cacheKey, false);
        return false;
    }

    private record CacheKey(BitSet b, int desiredTotal) {

    }

}

