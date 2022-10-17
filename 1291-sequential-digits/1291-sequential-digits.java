/*
1000000000
123456789

9, 1 digits (1,2,3,4,5,6,7,8,9)
8 2 digits (12, 23, 34, 45, 56, 67, 78, 89)
7 2 digits (123, 234, 345, 456, 567, 678, 789)
*/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        return getAllSequentialDigitsLessThan(high).stream()
            .filter(n -> n >= low)
            .toList();
    }
    
    private List<Integer> getAllSequentialDigitsLessThan(int high) {
        List<Integer> result = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int prev = 0;
        while (true) {
            int limit = result.size();
            int count = 0;
            for (int i = prev; i < limit; ++i) {
                int n = result.get(i);
                int lastDigit = n % 10;
                if (lastDigit < 9) {
                    int value = 10 * n + lastDigit + 1;
                    if (value <= high) {
                        result.add(value);
                        count++;
                    }
                }
            }
            if (count == 0) {
                break;
            }
            prev = limit;
        }
        return result;
    }
}
