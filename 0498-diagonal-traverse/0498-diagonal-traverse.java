class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = -1;
        int i = 0;
        while (inRange(mat, x, y)) {
            int v = mat[y][x];
            result[i] = v;
            i++;
            if (inRange(mat, x + dx, y + dy)) {
                x += dx;
                y += dy;
            } else {
                if (dx > 0) {
                    if (x + 1 < mat[0].length) {
                        x++;
                    } else {
                        y++;
                    }
                } else {
                    if (y + 1 < mat.length) {
                        y++;
                    } else {
                        x++;
                    }
                }
                dx *= -1;
                dy *= -1;
            }
        }
        return result;
    }

    private boolean inRange(int[][] mat, int x, int y) {
        return x >= 0 && x < mat[0].length && y >= 0 && y < mat.length;
    }
}