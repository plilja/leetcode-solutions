class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseToPrereq = new HashMap<>();
        Map<Integer, Set<Integer>> courseToDependants = new HashMap<>();
        for (int[] prereq : prerequisites) {
            int a = prereq[0];
            int b = prereq[1];
            courseToPrereq.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            courseToDependants.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (courseToPrereq.computeIfAbsent(i, k -> new HashSet<>()).isEmpty()) {
                q.add(i);
            }
        }
        int coursesFinished = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            coursesFinished++;
            for (int dep : courseToDependants.computeIfAbsent(course, k -> new HashSet<>())) {
                Set<Integer> prereq = courseToPrereq.get(dep);
                prereq.remove(course);
                if (prereq.isEmpty()) {
                    q.add(dep);
                }
            }
        }
        return coursesFinished == numCourses;
    }
}
