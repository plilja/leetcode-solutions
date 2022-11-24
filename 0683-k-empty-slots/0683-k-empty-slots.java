class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> on = new TreeSet<>();
        for (int day = 0; day < bulbs.length; ++day) {
            int bulb = bulbs[day];
            on.add(bulb);
            Integer prevBulb = on.floor(bulb - 1);
            if (prevBulb != null && bulb - prevBulb - 1 == k) {
                return day + 1;
            }
            Integer nextBulb = on.ceiling(bulb + 1);
            if (nextBulb != null && nextBulb - bulb - 1 == k) {
                return day + 1;
            }
        }
        return -1;
    }
}