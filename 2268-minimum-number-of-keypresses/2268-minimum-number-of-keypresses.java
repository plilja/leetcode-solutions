class Solution {
    record Item(int count, char c) implements Comparable<Item> {
        @Override
        public int compareTo(Item other) {
            if (count != other.count) {
                return -(count - other.count);
            } else {
                return c - other.c;
            }
        }
    }
    
    public int minimumKeypresses(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            counter.merge(c, 1, (a, b) -> a + b);
        }
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (var entry : counter.entrySet()) {
            pq.add(new Item(entry.getValue(), entry.getKey()));
        }
        int result = 0;
        int keypad = 1;
        int mappedAtKey = 1;
        while (!pq.isEmpty()) {
            var item = pq.poll();
            result += item.count * mappedAtKey;
            if (keypad == 9) {
                keypad = 1;
                mappedAtKey++;
            } else {
                keypad++;
            }
        }
        return result;
    }
}
