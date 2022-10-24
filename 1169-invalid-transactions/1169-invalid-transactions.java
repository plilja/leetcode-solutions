class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < transactions.length; ++i) {
            String[] transaction1 = transactions[i].split(",");
            String name1 = transaction1[0];
            int time1 = Integer.parseInt(transaction1[1]);
            int amount1 = Integer.parseInt(transaction1[2]);
            String city1 = transaction1[3];
            boolean valid = amount1 <= 1000;
            for (int j = 0; j < transactions.length && valid; ++j) {
                if (i == j) {
                    continue;
                }
                String[] transaction2 = transactions[j].split(",");
                String name2 = transaction2[0];
                int time2 = Integer.parseInt(transaction2[1]);
                int amount2 = Integer.parseInt(transaction2[2]);
                String city2 = transaction2[3];
                if (name1.equals(name2) && Math.abs(time1 - time2) <= 60 && !city1.equals(city2)) {
                    valid = false;
                }
            }
            if (!valid) {
                result.add(transactions[i]);
            }
        }
        return result;
    }
}