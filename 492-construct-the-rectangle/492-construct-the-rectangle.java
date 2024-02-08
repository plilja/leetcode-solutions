class Solution {
    public int[] constructRectangle(int area) {
        int start = (int) Math.ceil(Math.sqrt(area));
        for (int length = start; length < area; ++length) {
            int width = area / length;
            if (width * length == area) {
                return new int[]{length, width};
            }
        }
        return new int[]{area, 1};
    }
}
