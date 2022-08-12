class Solution {
    record IdxAndValue (
        int idx,
        int value
    ) {
    }
    
    public int trap(int[] heights) {
        int n = heights.length;
        int[] leftMax = new int[heights.length];
        for (int i = 0; i < n; ++i) {
            int height = heights[i];
            if (i == 0) {
                leftMax[i] = height;
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height);
            }
        }
        int[] rightMax = new int[heights.length];
        for (int i = n - 1; i >= 0; --i) {
            int height = heights[i];
            if (i == n - 1) {
                rightMax[i] = height;
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], height);
            }
        }
        int result = 0;
        for (int i = 1; i < n; ++i) {
            result += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return result;
    }
}
