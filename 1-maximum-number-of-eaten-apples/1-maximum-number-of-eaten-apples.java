class Solution {
    record AppleBatch(int numApples, int rotsAtDay) implements Comparable<AppleBatch> {
        
        @Override
        public int compareTo(AppleBatch other) {
            if (rotsAtDay != other.rotsAtDay) {
                return rotsAtDay - other.rotsAtDay;
            } else {
                return numApples - other.numApples;
            }
        }
    }
    
    public int eatenApples(int[] apples, int[] days) {
        int result = 0;
        PriorityQueue<AppleBatch> q = new PriorityQueue<>();
        int i = 0;
        while (i < apples.length || !q.isEmpty()) {
            if (i < apples.length) {
                q.add(new AppleBatch(apples[i], i + days[i]));
            }
            while (!q.isEmpty() && (q.peek().numApples() == 0 || q.peek().rotsAtDay() <= i)) {
                q.poll();
            }
            if (!q.isEmpty()) {
                AppleBatch appleBatch = q.poll();
                AppleBatch newAppleBatch = new AppleBatch(appleBatch.numApples() - 1, appleBatch.rotsAtDay());
                q.add(newAppleBatch);
                result++;
            }
            i++;
        }
        return result;
    }
}
