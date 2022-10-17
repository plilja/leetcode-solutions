class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = k;
        for (int i = num.length - 1; i >= 0; --i) {
            int v = num[i];
            v += carry;
            result.add(v % 10);
            carry = v / 10;
        }
        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}