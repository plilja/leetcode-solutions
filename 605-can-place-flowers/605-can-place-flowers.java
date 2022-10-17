class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int rem = n;
        int i = 0;
        while (rem > 0 && i < flowerbed.length) {
            int adj = flowerbed[i];
            if (i > 0 && flowerbed[i - 1] == 1) {
                adj++;
            }
            if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                adj++;
            }
            if (adj == 0) {
                rem--;
                flowerbed[i] = 1;
            }
            i++;
        }
        return rem == 0;
    }
}
