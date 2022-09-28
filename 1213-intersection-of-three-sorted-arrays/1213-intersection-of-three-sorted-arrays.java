class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i1 < arr1.length && i2 < arr2.length && i3 < arr3.length) {
            int a = arr1[i1];
            int b = arr2[i2];
            int c = arr3[i3];
            if (a == b && b == c) {
                result.add(a);
                i1++;
                i2++;
                i3++;
            }
            if (a < b || a < c) {
                i1++;
            } 
            if (b < a || b < c) {
                i2++;
            }
            if (c < a || c < b) {
                i3++;
            }
        }
        return result;
    }
}