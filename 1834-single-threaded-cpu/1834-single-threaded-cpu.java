class Solution {
    public int[] getOrder(int[][] tasksArr) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < tasksArr.length; ++i) {
            tasks.add(new Task(i, tasksArr[i][0], tasksArr[i][1]));
        }
        Collections.sort(tasks, (a, b) -> {
            return a.enqTime - b.enqTime;
        });
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.procTime != b.procTime) {
                return a.procTime - b.procTime;
            } else {
                return a.index - b.index;
            }
        });
        int i = 0;
        int[] result = new int[tasks.size()];
        int time = 0;
        int nextTask = 0;
        while (nextTask < tasks.size() || !pq.isEmpty()) {
            while (nextTask < tasks.size() && tasks.get(nextTask).enqTime <= time) {
                var task = tasks.get(nextTask);
                pq.add(task);
                nextTask++;
            }
            if (pq.isEmpty()) {
                time = tasks.get(nextTask).enqTime;
                continue;
            }
            var task = pq.poll();
            result[i] = task.index;
            i++;
            time += task.procTime;
        }
        return result;
    }
    
    private record Task(int index, int enqTime, int procTime) {
    }
}