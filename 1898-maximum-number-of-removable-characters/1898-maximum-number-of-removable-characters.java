class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int a = 0;
        int b = removable.length + 1;
        while (a < b) {
            int middle = (a + b) / 2;
            if (isSubSequence(s, p, removable, middle)) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a - 1;
    }
    
    private boolean isSubSequence(String s, String p, int[] removable, int k) {
        int[] removedIndices = new int[k];
        for (int i = 0; i < k; ++i) {
            removedIndices[i] = removable[i];
        }
        Arrays.sort(removedIndices);
        int removedPointer = 0;
        int pPointer = 0;
        for (int i = 0; i < s.length() && pPointer < p.length(); ++i) {
            while (removedPointer < k && removedIndices[removedPointer] < i) {
                removedPointer++;
            }
            if (removedPointer < k && removedIndices[removedPointer] == i) {
                continue;
            }
            char cs = s.charAt(i);
            char cp = p.charAt(pPointer);
            if (cs == cp) {
                pPointer++;
            }
        }
        return pPointer == p.length();
    }
}