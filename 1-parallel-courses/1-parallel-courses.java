class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, Set<Integer>> courseToPrereq = new HashMap<>();
        Map<Integer, Set<Integer>> prereqToCourses = new HashMap<>();
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            prereqToCourses.computeIfAbsent(prev, k -> new HashSet<>()).add(next);
            courseToPrereq.computeIfAbsent(next, k -> new HashSet<>()).add(prev);
        }
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> courseToSemester = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            if (courseToPrereq.computeIfAbsent(i, k -> new HashSet<>()).isEmpty()) {
                q.add(i);
                courseToSemester.put(i, 1);
            }
        }
        int result = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            int semester = courseToSemester.get(course);
            result = Math.max(result, semester);
            for (int dep : prereqToCourses.getOrDefault(course, Set.of())) {
                Set<Integer> prereq = courseToPrereq.get(dep);
                prereq.remove(course);
                if (prereq.isEmpty()) {
                    q.add(dep);
                    courseToSemester.put(dep, semester + 1);
                }
            }
        }
        if (courseToSemester.size() != n) {
            return -1;
        } else {
            return result;
        }
    }
}
