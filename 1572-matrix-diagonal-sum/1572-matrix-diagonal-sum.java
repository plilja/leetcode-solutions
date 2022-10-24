class Solution {
    public int diagonalSum(int[][] mat) {
        int x = 0;
        int y = 0;
        int result = 0;
        while (x < mat[0].length && y < mat.length) {
            result += mat[y][x];
            x++;
            y++;
        }
        x = mat.length - 1;
        y = 0;
        while (x >= 0 && y < mat.length) {
            if (x != y) {
                result += mat[y][x];
            }
            x--;
            y++;
        }
        return result;
    }
}