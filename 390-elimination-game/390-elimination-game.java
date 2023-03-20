class Solution {
    public int lastRemaining(int n) {
        return solve(1, n, 2);
    }

    private int solve(int start, int end, int step) {
        assert start <= end;
        if (start == end) {
            return start;
        } else {
            int diff = end - start + 1;
            boolean endsWithRemove = (diff % Math.abs(step)) == 1;
            if (step > 0) {
                int newEnd = endsWithRemove ? end - step / 2 : end;
                return solve(start + step / 2, newEnd, -step * 2);
            } else {
                int newStart = endsWithRemove ? start - step / 2 : start;
                return solve(newStart, end + step / 2, -step * 2);
            }
        }
    }
}
