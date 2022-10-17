class Solution {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
            .mapToObj(n -> String.valueOf(n))
            .sorted((a, b) -> -(a + b).compareTo((b + a)))
            .reduce((a, b) -> a + b)
            .orElse("")
            .replaceAll("^0+", "0");

    }
}
