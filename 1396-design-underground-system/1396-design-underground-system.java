class UndergroundSystem {
    private final Map<String, Double> travelToSum = new HashMap<>();
    private final Map<String, Integer> travelToCount = new HashMap<>();
    private final Map<Integer, Integer> checkinTimes = new HashMap<>();
    private final Map<Integer, String> checkinStations = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkinTimes.put(id, t);
        checkinStations.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int checkinTime = checkinTimes.remove(id);
        String checkinStation = checkinStations.remove(id);
        double time = t - checkinTime;
        String travelKey = "%s-%s".formatted(checkinStation, stationName);
        travelToSum.merge(travelKey, time, (a, b) -> a + b);
        travelToCount.merge(travelKey, 1, (a, b) -> a + b);
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String travelKey = "%s-%s".formatted(startStation, endStation);
        return  travelToSum.get(travelKey) / travelToCount.get(travelKey);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */