class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] solved = new boolean[3];
        boolean[] solves = new boolean[3];
        for (int i = 0; i < triplets.length && (!solved[0] || !solved[1] || !solved[2]); ++i) {
            int[] triplet = triplets[i];
            boolean possible = true;
            int solveCount = 0;
            for (int j = 0; j < 3; ++j) {
                solves[j] = false;
            }
            for (int j = 0; j < 3; ++j) {
                if (triplet[j] == target[j]) {
                    solves[j] = true;
                    solveCount++;
                }
                if (triplet[j] > target[j]) {
                    possible = false;
                    break;
                }
            }
            if (possible && solveCount > 0) {
                for (int j = 0; j < 3; ++j) {
                    solved[j] = solved[j] || solves[j];
                }
            }
        }
        return solved[0] && solved[1] && solved[2];
    }
}
