/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        return solve(n, 0);
    }
    
    private int solve(int n, int i) {
        for (int j = i + 1; j < n; ++j) {
            if (knows(i, j)) {
                return solve(n, j);
            }
        }
        for (int j = i - 1; j >= 0; --j) {
            if (knows(i, j)) {
                return -1;
            }
        }
        for (int j = 0; j < n; ++j) {
            if (i != j && !knows(j, i)) {
                return -1;
            }
        }
        return i;
    }
}