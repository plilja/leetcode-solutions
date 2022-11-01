class Solution {
    public int kSimilarity(String s1, String s2) {
        return solve(s1.toCharArray(), s2.toCharArray(), 0, new HashMap<>());
    }
    
    private int solve(char[] s1, char[] s2, int i, HashMap<String, Integer> dp) {
        if (s1.length == i) {
            return 0;
        }
        String cacheKey = "%s-%s-%d".formatted(new String(s1), new String(s2), i);
        Integer cached = dp.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        int result = s1.length + 1;
        char c1 = s1[i];
        char c2 = s2[i];
        if (c1 == c2) {
            return solve(s1, s2, i + 1, dp);
        } else {
            for (int j = i + 1; j < s2.length; ++j) {
                char c3 = s1[j];
                char c4 = s2[j];
                if (c2 == c3 && c1 == c4) {
                    swap(s1, i, j);
                    result = solve(s1, s2, i + 1, dp) + 1;
                    swap(s1, i, j);
                    break;
                }
                if (c3 == c2) {
                    swap(s1, i, j);
                    int sub = solve(s1, s2, i + 1, dp) + 1;
                    result = Math.min(result, sub);
                    swap(s1, i, j);
                }
            }
        }
        dp.put(cacheKey, result);
        return result;
    }
    
    private void swap(char[] arr, int a, int b) {
        char aTmp = arr[a];
        arr[a] = arr[b];
        arr[b] = aTmp;
    }
}