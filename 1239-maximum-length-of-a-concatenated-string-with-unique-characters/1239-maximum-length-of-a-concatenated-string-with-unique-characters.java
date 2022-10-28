class Solution {
    public int maxLength(List<String> arr) {
        return solve(arr, 0, new HashMap<>());
    }
    
    private int solve(List<String> arr, int i, Map<Character, Integer> counts) {
        if (i == arr.size()) {
            return 0;
        }
        int result = 0;
        for (int j = i; j < arr.size(); ++j) {
            String s = arr.get(j);
            boolean uniq = true;
            for (int k = 0; k < s.length(); ++k) {
                char c = s.charAt(k);
                int count = counts.getOrDefault(c, 0);
                if (count > 0) {
                    uniq = false;
                }
                counts.put(c, count + 1);
            }
            if (uniq) {
                result = Math.max(result, solve(arr, j + 1, counts) + s.length());
            }
            for (int k = 0; k < s.length(); ++k) {
                char c = s.charAt(k);
                counts.merge(c, -1, (a, b) -> a + b);
            }
        }
        return result;
    }
}