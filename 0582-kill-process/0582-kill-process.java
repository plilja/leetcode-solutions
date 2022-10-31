class Solution {
    public List<Integer> killProcess(List<Integer> pids, List<Integer> ppids, int kill) {
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 0; i < pids.size(); ++i) {
            int pid = pids.get(i); 
            int ppid = ppids.get(i); 
            children.computeIfAbsent(ppid, k -> new ArrayList<>()).add(pid);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.add(kill);
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int pid = q.poll();
            result.add(pid);
            for (int p : children.getOrDefault(pid, List.of())) {
                q.add(p);
            }
        }
        return result;
    }
}