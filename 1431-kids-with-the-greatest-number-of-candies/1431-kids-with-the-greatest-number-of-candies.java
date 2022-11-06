class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = Integer.MIN_VALUE;
        for (int n : candies) {
            greatest = Math.max(greatest, n);
        }
        List<Boolean> result = new ArrayList<>();
        for (int n : candies) {
            if (n + extraCandies >= greatest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}