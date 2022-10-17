class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Integer[]> result = new ArrayList<>();
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int[] first = firstList[firstPointer];
            int[] second = secondList[secondPointer];
            if (overlaps(first, second)) {
                result.add(new Integer[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
            }
            if (first[1] < second[1]) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }
        int[][] result2 = new int[result.size()][2];
        for (int i = 0; i < result.size(); ++i) {
            result2[i][0] = result.get(i)[0];
            result2[i][1] = result.get(i)[1];
        }
        return result2;
    }
    
    private boolean overlaps(int[] first, int[] second) {
        if (first[0] <= second[0] && first[1] >= second[0]) {
            return true;
        }
        if (second[0] <= first[0] && second[1] >= first[0]) {
            return true;
        }
        return false;
    }
}
