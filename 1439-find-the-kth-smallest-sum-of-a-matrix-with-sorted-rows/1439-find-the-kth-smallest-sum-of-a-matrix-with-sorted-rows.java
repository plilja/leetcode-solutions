class Solution {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> values = new ArrayList<>();
        values.add(0);
        for (int y = 0; y < mat.length; ++y) {
            ArrayList<Integer> newValues = new ArrayList<>();
            int acc = 0;
            for (int x = 0; x < mat[y].length; ++x) {
                for (int v : values) {
                    newValues.add(mat[y][x] + v);
                }
            }
            newValues.sort((a, b) -> a - b);
            values = newValues.subList(0, Math.min(newValues.size(), k));
        }
        return values.get(k - 1);
    }
}