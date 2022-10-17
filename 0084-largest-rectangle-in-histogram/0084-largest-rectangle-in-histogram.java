class Solution {
    record Elem(int index, int value) {}
    
    public int largestRectangleArea(int[] heights) {
        int[] smallerLeft = calcSmallerLeft(heights);
        int[] smallerRight = calcSmallerRight(heights);
        int result = 0;
        for (int i = 0; i < heights.length; ++i) {
            int h = heights[i];
            int area = h * (smallerRight[i] - smallerLeft[i] - 1);
            result = Math.max(result, area);
        }
        return result;
    }
    
    private int[] calcSmallerLeft(int[] heights) {
        Deque<Elem> stackLeft = new ArrayDeque<>();
        int[] smallerLeft = new int[heights.length];
        for (int i = 0; i < heights.length; ++i) {
            int h = heights[i];
            while (!stackLeft.isEmpty() && stackLeft.peekLast().value() >= h) {
                stackLeft.pollLast();
            }
            if (stackLeft.isEmpty()) {
                smallerLeft[i] = -1;
            } else {
                smallerLeft[i] = stackLeft.peekLast().index();
            }
            stackLeft.add(new Elem(i, h));
        }
        return smallerLeft;
    }
    
    private int[] calcSmallerRight(int[] heights) {
        Deque<Elem> stackRight = new ArrayDeque<>();
        int[] smallerRight = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; --i) {
            int h = heights[i];
            while (!stackRight.isEmpty() && stackRight.peekLast().value() >= h) {
                stackRight.pollLast();
            }
            if (stackRight.isEmpty()) {
                smallerRight[i] = heights.length;
            } else {
                smallerRight[i] = stackRight.peekLast().index();
            }
            stackRight.add(new Elem(i, h));
        }
        return smallerRight;
    }
}
