class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        Deque<Integer> expectedLength = new ArrayDeque<>();
        expectedLength.add(2);
        while (sb.length() < n) {
            int len = expectedLength.poll();
            int nextDigit = sb.charAt(sb.length() - 1)  == '1' ? 2 : 1;
            for (int i = 0; i < len; i++) {
                sb.append(nextDigit);
                expectedLength.add(nextDigit);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }
}
