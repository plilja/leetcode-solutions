class Solution {
    public int minimizeXor(int num1, int num2) {
        int bits = numBitsSet(num2);
        int result = 0;
        for (int i = 30; i >= 0 && bits > 0; --i) {
            int b = 1 << i;
            if ((num1 & b) != 0) {
                result |= b;
                bits--;
            }
        }
        int j = 0;
        while (bits > 0) {
            int b = 1 << j;
            if ((result & b) == 0) {
                result |= b;
                bits--;
            }
            j++;
        }
        return result;
    }
    
    private int numBitsSet(int n) {
        int result = 0;
        int curr = n;
        while (curr != 0) {
            if ((curr & 1) != 0) {
                result++;
            }
            curr >>= 1;
        }
        return result;
    }
}