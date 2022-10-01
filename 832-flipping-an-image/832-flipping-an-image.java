class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int y = 0; y < image.length; ++y) {
            for (int x = 0; x < image[0].length / 2; ++x) {
                swap(image[y], x, image[0].length - 1 - x);
            }
        }
        for (int y = 0; y < image.length; ++y) {
            for (int x = 0; x < image[0].length; ++x) {
                image[y][x] = (image[y][x] + 1) % 2;
            }
        }
        return image;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
}