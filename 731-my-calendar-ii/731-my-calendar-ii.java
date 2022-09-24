class MyCalendarTwo {
    private final List<Event> events = new ArrayList<>();

    public MyCalendarTwo() {
    }
    
    public boolean book(int start, int end) {
        var newEvent = new Event(start, end);
        if (!tripleBooking(newEvent)) {
            events.add(newEvent);
            return true;
        } else {
            return false;
        }
    }
    
    private boolean tripleBooking(Event newEvent) {
        List<Event> clashes = new ArrayList<>();
        for (var event : events) {
            if (overlaps(event, newEvent)) {
                var clashInterval = new Event(
                    Math.max(event.start(), newEvent.start()),
                    Math.min(event.end(), newEvent.end())
                );
                clashes.add(clashInterval);
            }
        }
        for (int i = 0; i < clashes.size(); ++i) {
            for (int j = i + 1; j < clashes.size(); ++j) {
                if (overlaps(clashes.get(i), clashes.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean overlaps(Event a, Event b) {
        if (a.start() <= b.start() && a.end() > b.start()) {
            return true;
        } else if (b.start() <= a.start() && b.end() > a.start()) {
            return true;
        }
        return false;
    }

    
    private record Event(int start, int end) {
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */