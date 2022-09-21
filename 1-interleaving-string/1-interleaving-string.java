class Solution {
     private final Map<Params, Boolean> cache = new HashMap<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return solve(s1, s2, s3, new Params(0, 0));
    }
    
    /*
       Recusive solution with memoization.
    */
    private boolean solve(String s1, String s2, String s3, Params params) {
        if (cache.containsKey(params)) {
            return cache.get(params);
        }
        if (params.i() + params.j() == s3.length()) {
            return true;
        }
        boolean result = false;
        if (params.i() < s1.length() && s1.charAt(params.i()) == s3.charAt(params.i() + params.j())) {
            result = result || solve(s1, s2, s3, new Params(params.i() + 1, params.j()));
        }
        if (params.j() < s2.length() && s2.charAt(params.j()) == s3.charAt(params.i() + params.j())) {
            result = result || solve(s1, s2, s3, new Params(params.i(), params.j() + 1));
        }
        cache.put(params, result);
        return result;
    }
    
    private record Params(int i, int j) {
    }
}
