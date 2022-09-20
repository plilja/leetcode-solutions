class Solution {
    public int[] arrayRankTransform(int[] arr) {
        List<Integer> numsSorted = new ArrayList<>();
        for (int n : arr) {
            numsSorted.add(n);
        }
        Collections.sort(numsSorted);
        Map<Integer, Integer> numToRank = new HashMap<>();
        int nextRank = 1;
        for (int n : numsSorted) {
            if (!numToRank.containsKey(n)) {
                numToRank.put(n, nextRank);
                nextRank++;
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = numToRank.get(arr[i]);
        }
        return result;
    }
}
