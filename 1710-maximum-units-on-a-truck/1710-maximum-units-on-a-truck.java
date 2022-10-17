class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        TreeMap<Integer, Integer> boxUnitsToCount = new TreeMap<>((a, b) -> b - a);
        for (int[] boxType : boxTypes) {
            int boxCount = boxType[0];
            int boxUnits = boxType[1];
            boxUnitsToCount.merge(boxUnits, boxCount, (a, b) -> a + b);
        }
        int result = 0;
        int remainingTruckSize = truckSize;
        for (var entry : boxUnitsToCount.entrySet()) {
            int units = entry.getKey();
            int count = entry.getValue();
            int countToUse = Math.min(remainingTruckSize, count);
            result += countToUse * units;
            remainingTruckSize -= countToUse;
            if (remainingTruckSize <= 0) {
                break;
            }
        }
        return result;
    }
}
