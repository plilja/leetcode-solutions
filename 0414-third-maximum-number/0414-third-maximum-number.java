class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> q = new TreeSet<>();
        for (int n : nums) {
            q.add(n);
            while (q.size() > 3) {
                q.pollFirst();
            }
        }
        if (q.size() < 3) {
            return q.last();
        } else {
            return q.first();
        }
    }
}
