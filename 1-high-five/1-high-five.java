class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> studentToScores = new TreeMap<>();
        for (int[] item : items) {
            int student = item[0];
            int score = item[1];
            var pq = studentToScores.computeIfAbsent(student, k -> new PriorityQueue<>((a, b) -> a - b));
            pq.add(score);
            while (pq.size() > 5) {
                pq.poll();
            }
        }
        int[][] result = new int[studentToScores.size()][2];
        int i = 0;
        for (var entry : studentToScores.entrySet()) {
            int sum = 0;
            var pq = entry.getValue();
            int num = pq.size();
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            int average = sum / num;
            result[i] = new int[]{entry.getKey(), average};
            i++;
        }
        return result;
    }
}
