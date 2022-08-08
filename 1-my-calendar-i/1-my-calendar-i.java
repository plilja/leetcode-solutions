class MyCalendar {
    private final TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        var floor = calendar.floorEntry(end - 1);
        var ceiling = calendar.ceilingEntry(start);
        boolean floorOverlaps = floor != null && overlaps(floor.getKey(), floor.getValue(), start, end);
        boolean ceilingOverlaps = ceiling != null && overlaps(ceiling.getKey(), ceiling.getValue(), start, end);
        if (!floorOverlaps && !ceilingOverlaps) {
            calendar.put(start, end);
            return true;
        } else {
            return false;
        }
    }
    
    private boolean overlaps(int startA, int endA, int startB, int endB) {
        return (startA <= startB && endA > startB) ||
                (startB <= startA && endB > startA);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
