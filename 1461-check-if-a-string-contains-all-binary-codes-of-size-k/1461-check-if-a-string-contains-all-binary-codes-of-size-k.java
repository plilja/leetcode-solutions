class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> codes = new HashSet<>();
        for (int i = k; i <= s.length(); ++i) {
            String code = s.substring(i - k, i);
            codes.add(code);
        }
        return codes.size() == (1 << k);
    }
}