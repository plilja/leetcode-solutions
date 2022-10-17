class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1]) {
            return false;
        }
        boolean increasing = true;
        int prev = arr[1];
        for (int i = 2; i < arr.length; ++i) {
            int v = arr[i];
            if (prev == v) {
                return false; // not strictly decreasing/increasing
            }
            if (increasing) {
                if (prev > v) {
                    increasing = false; // found a potential peak
                }
            } else {
                if (prev < v) {
                    return false;
                }
            }
            prev = v;
        }
        return !increasing;
    }
}