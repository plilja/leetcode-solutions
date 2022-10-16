class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int n : nums) {
            distinct.add(n);
            String s = String.valueOf(n);
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; --i) {
                sb.append(s.charAt(i));
            }
            distinct.add(Integer.parseInt(sb.toString()));
        }
        return distinct.size();
    }
}