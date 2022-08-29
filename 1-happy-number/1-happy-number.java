class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int curr = n;
        while (curr != 1 && !seen.contains(curr)) {
            seen.add(curr);
            String str = String.valueOf(curr);
            curr = 0;
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                int k = Integer.parseInt("" + c);
                curr += k * k;
            }
        }
        return curr == 1;
    }
}
