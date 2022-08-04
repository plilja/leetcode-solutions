class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : changed) {
            counter.merge(n, 1, (a, b) -> a + b);
        }
        ArrayList<Integer> original = new ArrayList<>();
        List<Integer> changedSorted = new ArrayList<>();
        for (int n : changed) {
            changedSorted.add(n);
        }
        Collections.sort(changedSorted, (a, b) -> Math.abs(a) - Math.abs(b));
        for (int n : changedSorted) {
            int nCount = counter.get(n);
            int doubleCount = counter.getOrDefault(2 * n, 0);
            if (nCount > 0) {
                int neededCount = n == 0 ? 2 : 1;
                if (doubleCount < neededCount) {
                    return new int[]{};
                } else {
                    original.add(n);
                    counter.put(n, nCount - 1);
                    counter.merge(2 * n, -1, (a, b) -> a + b);
                }
            }
        }
        if (original.size() == changed.length / 2) {
            int[] result = new int[original.size()];
            for (int i = 0; i < original.size(); ++i) {
                result[i] = original.get(i);
            }
            return result;
        } else {
            return new int[]{};
        }
        
    }
}
