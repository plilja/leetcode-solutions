class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int result = Integer.MIN_VALUE;
        for (int fact1 : List.of(1, -1)) {
            for (int fact2 : List.of(1, -1)) {
                int smallest = Integer.MAX_VALUE;
                for (int i = 0; i < arr1.length; ++i) {
                    int val = arr1[i] * fact1 + arr2[i] * fact2 + i;
                    if (i == 0) {
                        smallest = val;
                    } else {
                        result = Math.max(result, val - smallest);
                        smallest = Math.min(val, smallest);
                    }
                    
                }
            }
        }
        return result;
    }
}