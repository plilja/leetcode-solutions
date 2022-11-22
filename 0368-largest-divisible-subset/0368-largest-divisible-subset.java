class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> graph = createDivisorsGraph(nums);
        return findLongestPath(nums, graph);
    }
    
    private Map<Integer, List<Integer>> createDivisorsGraph(int[] nums) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> multiples = new ArrayList<>();
            int v1 = nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                int v2 = nums[j];
                if (v2 % v1 == 0) {
                    multiples.add(v2);
                }
            }
            graph.put(v1, multiples);
        }
        return graph;
    }
    
    private List<Integer> findLongestPath(int[] nums, Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> longestPaths = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int v1 = nums[i];
            List<Integer> longestPath = new ArrayList<>();
            longestPath.add(v1);
            for (int j = i + 1; j < nums.length; ++j) {
                int v2 = nums[j];
                if (v2 % v1 == 0) {
                    List<Integer> otherPath = longestPaths.get(v2);
                    if (otherPath.size() >= longestPath.size()) {
                        longestPath.clear();
                        longestPath.add(v1);
                        longestPath.addAll(otherPath);
                    }
                }
            }
            longestPaths.put(v1, longestPath);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> otherPath = longestPaths.get(nums[i]);
            if (otherPath.size() > result.size()) {
                result = otherPath;
            }
        }
        return result;
    }
}