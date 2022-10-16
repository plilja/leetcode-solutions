class SeatManager {
    private final TreeSet<Integer> seats = new TreeSet<>();

    public SeatManager(int n) {
        for (int i = 1; i <= n; ++i) {
            seats.add(i);
        }
    }
    
    public int reserve() {
        int f = seats.first();
        seats.remove(f);
        return f;
    }
    
    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */