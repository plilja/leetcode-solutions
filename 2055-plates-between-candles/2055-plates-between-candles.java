class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeSet<Integer> candles = new TreeSet<>();
        int[] candlesUpto = new int[s.length()];
        int rightmostCandle = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '|') {
                    candlesUpto[i] = 1;
                    candles.add(i);
                } else {
                    candlesUpto[i] = 0;
                }
            } else {
                if (c == '|') {
                    candlesUpto[i] = candlesUpto[i - 1] + 1;
                    candles.add(i);
                } else {
                    candlesUpto[i] = candlesUpto[i - 1];
                }
            }
        }

        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; ++j) {
            int[] query = queries[j];
            if (candles.ceiling(query[0]) == null) {
                continue;
            }
            if (candles.floor(query[1]) == null) {
                continue;
            }
            int from = candles.ceiling(query[0]) + 1;
            int to = candles.floor(query[1]) - 1;
            if (from <= to) {
                int candlesBetween = candlesUpto[to];
                if (from > 0) {
                    candlesBetween -= candlesUpto[from - 1];
                }
                result[j] = to - from + 1 - candlesBetween;
            } else {
                result[j] = 0;
            }
        }
        return result;
    }
}
