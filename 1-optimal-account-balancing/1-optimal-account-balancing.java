class Solution {
    public int minTransfers(int[][] transactions) {
        TreeMap<Integer, Integer> balances = new TreeMap<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];
            balances.merge(from, -amount, (a, b) -> a + b);
            balances.merge(to, amount, (a, b) -> a + b);
        }
        return minTransfersHelper(balances);
    }
    
    private int minTransfersHelper(TreeMap<Integer, Integer> balances) {
        if (balances.isEmpty()) {
            return 0;
        }
        var firstEntry = balances.firstEntry();
        int person = firstEntry.getKey();
        int balance = firstEntry.getValue();
        if (balance == 0) {
            balances.remove(person);
            int result = minTransfersHelper(balances);
            balances.put(person, 0);
            return result;
        }
        int lastPerson = balances.lastKey();
        int otherPerson = person + 1;
        int result = Integer.MAX_VALUE - 100;
        while (otherPerson <= lastPerson) {
            Integer otherBalance = balances.get(otherPerson);
            if (otherBalance != null) {
                int newBalance = balance + otherBalance;
                int newOtherBalance = balance + otherBalance;
                if (balance == -otherBalance) {
                    balances.remove(person);
                    balances.remove(otherPerson);
                    int sub = minTransfersHelper(balances) + 1;
                    result = Math.min(result, sub);
                } else if (Math.signum(balance) != Math.signum(otherBalance)) {
                    if (Math.abs(balance) > Math.abs(otherBalance)) {
                        balances.remove(otherPerson);
                        balances.put(person, balance + otherBalance);
                    } else {
                        balances.remove(person);
                        balances.put(otherPerson, otherBalance + balance);
                    }
                    int sub = minTransfersHelper(balances) + 1;
                    result = Math.min(result, sub);
                } 
                balances.put(person, balance);
                balances.put(otherPerson, otherBalance);
            }
            otherPerson++;
        }
        return result;
    }
}
