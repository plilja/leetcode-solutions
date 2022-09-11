class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int highestRight = 0;
        for (int i = heights.length - 1; i >= 0; --i) {
            int height = heights[i];
            if (height > highestRight) {
                result.add(i);
            }
            highestRight = Math.max(highestRight, height);
        }
        Collections.reverse(result);
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
