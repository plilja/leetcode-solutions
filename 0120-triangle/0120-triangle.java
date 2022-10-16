class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();
        dp.add(triangle.get(0).get(0));
        for (int j = 1; j < triangle.size(); ++j) {
            List<Integer> row = triangle.get(j);
            List<Integer> dp2 = new ArrayList<>();
            for (int i = 0; i < row.size(); ++i) {
                int v = Integer.MAX_VALUE;
                if (i > 0) {
                    v = Math.min(v, dp.get(i - 1) + row.get(i));
                } 
                if (i < dp.size()) {
                    v = Math.min(v, dp.get(i) + row.get(i));
                }
                dp2.add(v);
            }
            dp = dp2;
        }
        int result = Integer.MAX_VALUE;
        for (int n : dp) {
            result = Math.min(result, n);
        }
        return result;
    }
}