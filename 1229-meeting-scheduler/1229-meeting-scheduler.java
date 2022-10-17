class Solution {
    public List<Integer> minAvailableDuration(int[][] slotsArr1, int[][] slotsArr2, int duration) {
        List<Slot> slots1 = toSlotsList(slotsArr1);
        List<Slot> slots2 = toSlotsList(slotsArr2);
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < slots1.size() && pointer2 < slots2.size()) {
            Slot slot1 = slots1.get(pointer1);
            Slot slot2 = slots2.get(pointer2);
            int possibleStart = Math.max(slot1.start(), slot2.start());
            int possibleEnd = Math.min(slot1.end(), slot2.end());
            if (possibleEnd - possibleStart >= duration) {
                return List.of(possibleStart, possibleStart + duration);
            }
            if (slot1.end() < slot2.end()) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return List.of();
    }
    
    private List<Slot> toSlotsList(int[][] slots) {
        List<Slot> result = new ArrayList<>();
        for (int[] slot : slots) {
            result.add(new Slot(slot[0], slot[1]));
        }
        Collections.sort(result);
        return result;
    }
    
    record Slot(int start, int end) implements Comparable<Slot> {
        @Override
        public int compareTo(Slot other) {
            if (start == other.start) {
                return start - other.start;
            } else {
                return end - other.end;
            }
        }
    }
}
