class Solution {
    public int earliestAcq(int[][] logs, int n) {
        List<Set<Integer>> acq = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            var people = new HashSet<Integer>();
            people.add(i);
            acq.add(people);
        }
        TreeMap<Integer, Integer[]> logsSorted = new TreeMap<>();
        for (int[] log : logs) {
            logsSorted.put(log[0], new Integer[]{log[1], log[2]});
        }
        for (var entry : logsSorted.entrySet()) {
            int timestamp = entry.getKey();
            int personA = entry.getValue()[0];
            int personB = entry.getValue()[1];
            var acq1 = acq.get(personA);
            var acq2 = acq.get(personB);
            if (acq1 != acq2) {
                for (int person : acq2) {
                    acq.set(person, acq1);
                    acq1.add(person);
                }
            }
            if (acq1.size() == n) {
                return timestamp;
            }
        }
        return -1;
    }
}
