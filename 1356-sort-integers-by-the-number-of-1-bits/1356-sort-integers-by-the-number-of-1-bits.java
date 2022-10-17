class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> arrCopy = new ArrayList<>();
        for (int n : arr) {
            arrCopy.add(n);
        }
        Collections.sort(arrCopy, (a, b) -> {
            int aOnes = numOnes(a);
            int bOnes = numOnes(b);
            if (aOnes != bOnes) {
                return aOnes - bOnes;
            }
            return a - b;
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = arrCopy.get(i);
        }
        return arr;
    }
    
    private int numOnes(int a) {
        int result = 0;
        int current = a;
        while (current != 0) {
            if ((current & 1) != 0) {
                result++;
            }
            current >>= 1;
        }
        return result;
    }
}
