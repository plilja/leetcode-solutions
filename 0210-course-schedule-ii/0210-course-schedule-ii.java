class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseToPrerequisite = new HashMap<>();
        Map<Integer, Set<Integer>> courseToDependants = new HashMap<>();
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            courseToPrerequisite.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            courseToDependants.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (courseToPrerequisite.getOrDefault(i, Set.of()).isEmpty()) {
                q.add(i);
            }
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!q.isEmpty()) {
            int course = q.poll();
            result[i] = course;
            i++;
            for (int dep : courseToDependants.getOrDefault(course, Set.of())) {
                Set<Integer> pre = courseToPrerequisite.get(dep);
                pre.remove(course);
                if (pre.isEmpty()) {
                    q.add(dep);
                }
            }
        }
        if (i == numCourses) {
            return result;
        } else {
            return new int[]{};
        }
    }
}
