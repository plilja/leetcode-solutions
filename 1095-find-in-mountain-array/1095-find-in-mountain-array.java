/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int peak = getPeak(arr);
        int firstHalf = search(target, arr, 0, peak, val -> val < target);
        if (firstHalf != -1) {
            return firstHalf;
        }
        return search(target, arr, peak, arr.length() - 1, val -> val > target);
    }
    
    private int search(int target, MountainArray arr, int from, int to, Predicate<Integer> moveRight) {
        int a = from;
        int b = to;
        while (a < b) {
            int middle = (a + b) / 2;
            int val = arr.get(middle);
            if (val == target) {
                return middle;
            }
            if (moveRight.test(val)) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        if (arr.get(a) == target) {
            return a;
        }
        return -1;
    }
    
    public int getPeak(MountainArray arr) {
        int a = 0;
        int b = arr.length() - 1;
        while (a < b) {
            int middle = (a + b) / 2;
            if (arr.get(middle) < arr.get(middle + 1)) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a;
    }
}