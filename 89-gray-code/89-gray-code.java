/*
0000 0001 0011 0111 1111 1110 1100 1000

000 001 011 111 110 100 101 010

000 001 011 010 
100 101 111 110

00 01 11 10
*/
class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            return List.of(0, 1);
        }
        List<Integer> sub = grayCode(n - 1);
        List<Integer> result = new ArrayList<>();
        result.add(sub.get(0));
        int a = 1;
        int b = 0;
        while (a + 1 < sub.size() || b + 1 < sub.size()) {
            if (b + 1 < sub.size()) {
                result.add(prependOne(sub.get(b), n));
                result.add(prependOne(sub.get(b + 1), n));
                b += 2;
            }
            if (a + 1 < sub.size()) {
                result.add(sub.get(a));
                result.add(sub.get(a + 1));
                a += 2;
            }
        }
        result.add(sub.get(sub.size() - 1));
        return result;
    }
    
    private int prependOne(int value, int n) {
        String binaryString = Integer.toBinaryString(value);
        while (binaryString.length() < n - 1) {
            binaryString = "0" + binaryString;
        }
        return Integer.parseInt("1" + binaryString, 2);
    }
}