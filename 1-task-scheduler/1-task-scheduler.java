class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char c : tasks) {
            taskCounts.merge(c, 1, (a, b) -> a + b);
        }
        Map<Character, Integer> nextTime = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            if (taskCounts.getOrDefault(c, 0) > 0) {
                nextTime.put(c, 0);
            }
        }
        int time = 0;
        while (true) {
            int best = 0;
            char bestTask = '-';
            for (char c = 'A'; c <= 'Z'; ++c) {
                int count = taskCounts.getOrDefault(c, 0);
                int canBePerfomedAtTime = nextTime.getOrDefault(c, 0);
                if (count > best && canBePerfomedAtTime <= time) {
                    best = count;
                    bestTask = c;
                }
            }
            if (taskCounts.isEmpty()) {
                break;
            }
            if (best > 0) {
                int newCount = taskCounts.merge(bestTask, -1, (a, b) -> a + b);
                if (newCount == 0) {
                    taskCounts.remove(bestTask);
                }
                nextTime.put(bestTask, time + n + 1);
            }
            time++;
        }
        return time;
    }
}
