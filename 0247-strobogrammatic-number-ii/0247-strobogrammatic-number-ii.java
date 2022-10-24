/*
0 -> 0 ok identical (but not start of number)
1 -> 1 ok identical
2 -> x
3 -> x
4 -> x
5 -> x
6 -> 9 ok
7 -> x
8 -> 8 ok identical
9 -> 6 ok
*/
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    public List<String> helper(int n, int finalLength) {
        if (n == 0) {
            return List.of("");
        } else if (n == 1) {
            return List.of("0", "1", "8");
        } else {
            List<String> result = new ArrayList<>();
            List<String> subTwo = helper(n - 2, finalLength);
            for (String sub : subTwo) {
                if (n != finalLength) {
                    result.add("0" + sub + "0");
                }
                result.add("1" + sub + "1");
                result.add("8" + sub + "8");
                result.add("6" + sub + "9");
                result.add("9" + sub + "6");
            }
            return result;
        } 
    }
}