class Solution {
    public int numTimesAllBlue(int[] flips) {
        int totalOnes = 0;
        int onesLeft = 0;
        int[] bits = new int[flips.length]; 
        int result = 0;
        for (int i : flips) {
            totalOnes++;
            bits[i - 1] = 1;
            if (i - 1 == onesLeft) {
                for (int j = i - 1; j < bits.length; ++j) {
                    if (bits[j] == 1) {
                        onesLeft++;
                    } else {
                        break;
                    }
                }
            }
            if (totalOnes == onesLeft) {
                result++;
            }
        }
        return result;
    }
}
