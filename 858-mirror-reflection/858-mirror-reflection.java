class Solution {
    public int mirrorReflection(int p, int q) {
        int delta = q;
        int currentY = 0;
        int wall = 0;
        while (true) {
            currentY += delta;
            wall = (wall + 1) % 2;
            if (currentY == 0 && wall == 1) {
                return 0;
            }
            if (currentY == p) {
                if (wall == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
            if (currentY >= p) { 
                delta = -q;
                currentY = p - (currentY - p);
            }
            if (currentY <= 0) {
                currentY *= -1;
                delta = q;
            }
        }
        
    }
}
