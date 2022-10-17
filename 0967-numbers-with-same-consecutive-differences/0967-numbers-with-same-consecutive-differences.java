class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            solve(i, k, n - 1, result);
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
    
    private void solve(long current, int k, int digits, List<Integer> result) {
        if (digits == 0) {
            result.add((int) current);
        } else {
            long lastDigit = current % 10;
            if (lastDigit - k >= 0) {
                solve(current * 10 + lastDigit - k, k, digits - 1, result);
            }
            if (k != 0 && lastDigit + k < 10) {
                solve(current * 10 + lastDigit + k, k, digits - 1, result);
            }
        }
    }
}
