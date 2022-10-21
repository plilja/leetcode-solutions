class Solution {
    public int minFlips(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int diff1 = 0;
        int diff2 = 0;
        Deque<Character> seq1 = new ArrayDeque<>();
        Deque<Character> seq2 = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            if (seq1.isEmpty()) {
                seq1.add('0');
                seq2.add('1');
            } else {
                seq1.add(seq1.peekLast() == '0' ? '1' : '0');
                seq2.add(seq2.peekLast() == '0' ? '1' : '0');
            }
            char c = s.charAt(i);
            if (c != seq1.peekLast()) {
                diff1++;
            }
            if (c != seq2.peekLast()) {
                diff2++;
            }
        }
        int result = Math.min(diff1, diff2);
        for (int i = 1; i <= s.length(); ++i) {
            char lastChar = s.charAt(i - 1);
            if (lastChar != seq1.pollFirst()) {
                diff1--;
            }
            if (lastChar != seq2.pollFirst()) {
                diff2--;
            }
            seq1.add(seq1.peekLast() == '0' ? '1' : '0');
            seq2.add(seq2.peekLast() == '0' ? '1' : '0');
            if (seq1.peekLast() != lastChar) {
                diff1++;
            }
            if (seq2.peekLast() != lastChar) {
                diff2++;
            }
            result = Math.min(result, Math.min(diff1, diff2));
        }
        return result;
    }
}