class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for (int x = 0; x < mat[0].length; ++x) {
            sortDiag(x, 0, mat);
        }
        for (int y = 0; y < mat.length; ++y) {
            sortDiag(0, y, mat);
        }
        return mat;
    }
    
    private void sortDiag(int x, int y, int[][] mat) {
        List<Integer> values = new ArrayList<>();
        int x2 = x;
        int y2 = y;
        while (x2 < mat[0].length && y2 < mat.length) {
            values.add(mat[y2][x2]);
            x2++;
            y2++;
        }
        Collections.sort(values);
        int i = 0;
        x2 = x;
        y2 = y;
        while (x2 < mat[0].length && y2 < mat.length) {
            mat[y2][x2] = values.get(i);
            x2++;
            y2++;
            i++;
        }
    }
}