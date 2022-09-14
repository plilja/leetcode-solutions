class Solution {
    public int subtractProductAndSum(int n) {
        return digitProduct(n) - digitSum(n);
    }
    
    private int digitSum(int n) {
        int current = n;
        int result = 0;
        while (current != 0) {
            result += current % 10;
            current /= 10;
        }
        return result;
    }
    
    private int digitProduct(int n) {
        int current = n;
        int result = 1;
        while (current != 0) {
            result *= current % 10;
            current /= 10;
        }
        return result;
    }
}
