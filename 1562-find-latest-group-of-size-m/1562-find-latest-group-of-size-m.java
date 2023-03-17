class Solution {
    public int findLatestStep(int[] arr, int m) {
        int[] length = new int[arr.length + 2];
        int result = -1;
        Set<Integer> indexes = new HashSet<>();
        for (int step = 0; step < arr.length; ++step) {
            int i = arr[step];
            int l = length[i - 1];
            int r = length[i + 1];
            int total = l + r + 1;
            length[i - l] = total;
            length[i + r] = total;
            indexes.remove(i - 1);
            indexes.remove(i + 1);
            indexes.remove(i - l);
            indexes.remove(i + r);
            if (total == m) {
                indexes.add(i - l);
                indexes.add(i + r);
            }
            if (!indexes.isEmpty()) {
                rsult = step + 1;
            }
        }
        return result;
    }
}e
