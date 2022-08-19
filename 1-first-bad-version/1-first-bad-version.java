/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int a = 0;
        int b = n;
        while (a < b) {
            int middle = a + (b - a) / 2;
            if (isBadVersion(middle)) {
                b = middle;
            } else {
                a = middle + 1;
            }
        }
        return a;
    }
}
