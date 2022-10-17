class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        return knightProbabilityHelper(n, new Params(k, row, column), new HashMap<>());
    }
    
    private double knightProbabilityHelper(int n, Params params, Map<Params, Double> cache) {
        Double cached = cache.get(params);
        if (cached != null) {
            return cached;
        }
        if (params.row < 0 || params.column < 0 || params.row >= n || params.column >= n) {
            return 0D;
        }
        if (params.k() == 0) {
            return 1D;
        }
        double result = 0;
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() + 2, params.column() + 1), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() - 2, params.column() + 1), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() + 2, params.column() - 1), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() - 2, params.column() - 1), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() + 1, params.column() + 2), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() - 1, params.column() + 2), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() + 1, params.column() - 2), cache);
        result += 1/8D * knightProbabilityHelper(n, new Params(params.k() - 1, params.row() - 1, params.column() - 2), cache);
        cache.put(params, result);
        return result;
    }
    
    record Params (int k, int row, int column) {}
}
