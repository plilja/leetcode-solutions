class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> availableServers = new PriorityQueue<>();
        for (int i = 0; i < servers.length; ++i) {
            availableServers.add(new Server(i, servers[i]));
        }
        TreeSet<Integer> eventTimes = new TreeSet<>();
        for (int t = 0; t < tasks.length; ++t) {
            eventTimes.add(t);
        }
        int[] result = new int[tasks.length];
        Map<Integer, List<Server>> serverDoneTime = new HashMap<>();
        Deque<Task> taskQueue = new ArrayDeque<>();
        while (!eventTimes.isEmpty()) {
            int t = eventTimes.pollFirst();
            for (Server server : serverDoneTime.getOrDefault(t, List.of())) {
                availableServers.add(server);
            }
            if (t < tasks.length) {
                int task = tasks[t];
                taskQueue.add(new Task(t, task));
            }
            while (!availableServers.isEmpty() && !taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                Server server = availableServers.poll();
                serverDoneTime.computeIfAbsent(t + task.time(), k -> new ArrayList<>()).add(server);
                result[task.index] = server.index;
                eventTimes.add(t + task.time());
            }
        }
        return result;
    }
    
    private record Server(int index, int weight) implements Comparable<Server> {
        @Override
        public int compareTo(Server other) {
            if (weight != other.weight) {
                return weight - other.weight;
            } else {
                return index - other.index;
            }
        }
    }
    
    private record Task(int index, int time) {
        
    }
}