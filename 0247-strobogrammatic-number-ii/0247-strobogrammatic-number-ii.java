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
        if (n == 1) {
            return List.of("0", "1", "8");
        } else if (n == 2) {
            return List.of("11", "88", "69", "96");
        } else {
            Set<String> result = new TreeSet<>();
            if (n % 2 == 1) {
                List<String> subOne = findStrobogrammatic(n - 1);
                for (String sub : subOne) {
                    int middle = sub.length() / 2;
                    result.add(sub.substring(0, middle) + "0" + sub.substring(middle, sub.length()));
                    result.add(sub.substring(0, middle) + "1" + sub.substring(middle, sub.length()));
                    result.add(sub.substring(0, middle) + "8" + sub.substring(middle, sub.length()));
                }
            }
            List<String> subTwo = findStrobogrammatic(n - 2);
            for (String sub : subTwo) {
                result.add("1" + sub + "1");
                result.add("8" + sub + "8");
                result.add("6" + sub + "9");
                result.add("9" + sub + "6");
            }
            if (n % 2 == 0) {
                for (String sub : subTwo) {
                    int middle = sub.length() / 2;
                    result.add(sub.substring(0, middle) + "00" + sub.substring(middle, sub.length()));
                    result.add(sub.substring(0, middle) + "69" + sub.substring(middle, sub.length()));
                    result.add(sub.substring(0, middle) + "96" + sub.substring(middle, sub.length()));
                    result.add(sub.substring(0, middle) + "88" + sub.substring(middle, sub.length()));
                    result.add(sub.substring(0, middle) + "11" + sub.substring(middle, sub.length()));
                }
            }
            return new ArrayList<>(result);
        } 
    }
}