class LogAggregator {
    private final Map<Integer, List<Integer>> machineToLogs = new HashMap<>();
    private final Map<Integer, List<Integer>> serviceToLogs = new HashMap<>();
    private final Map<Integer, String> logs = new HashMap<>();

    public LogAggregator(int machines, int services) {
        
    }
    
    public void pushLog(int logId, int machineId, int serviceId, String message) {
        insert(machineToLogs.computeIfAbsent(machineId, k -> new ArrayList<>()), logId);
        insert(serviceToLogs.computeIfAbsent(serviceId, k -> new ArrayList<>()), logId);
        logs.put(logId, message);
    }
    
    private void insert(List<Integer> list, int value) {
        list.add(value);
    }
    
    public List<Integer> getLogsFromMachine(int machineId) {
        return machineToLogs.getOrDefault(machineId, List.of());
    }
    
    public List<Integer> getLogsOfService(int serviceId) {
        return serviceToLogs.getOrDefault(serviceId, List.of());
    }
    
    public List<String> search(int serviceId, String searchString) {
        List<String> result = new ArrayList<>();
        for (int logId : serviceToLogs.getOrDefault(serviceId, List.of())) {
            String log = logs.get(logId);
            if (log.contains(searchString)) {
                result.add(log);
            }
        }
        return result;
    }
}

/**
 * Your LogAggregator object will be instantiated and called as such:
 * LogAggregator obj = new LogAggregator(machines, services);
 * obj.pushLog(logId,machineId,serviceId,message);
 * List<Integer> param_2 = obj.getLogsFromMachine(machineId);
 * List<Integer> param_3 = obj.getLogsOfService(serviceId);
 * List<String> param_4 = obj.search(serviceId,searchString);
 */