class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        PriorityQueue<Pair<Integer, List<Integer>>> pq = new PriorityQueue<>(Comparator.comparing(Pair::left));
        Set<List<Integer>> visited = new HashSet<>();
        pq.add(new Pair<>(0, needs));
        while (true) {
            var top = pq.poll();
            int cost = top.left();
            List<Integer> remaining = top.right();
            if (visited.contains(remaining)) {
                continue;
            }
            visited.add(remaining);
            if (remaining.stream().allMatch(p -> p == 0)) {
                return cost;
            }
            // Buy one item from price list
            for (int i = 0; i < price.size(); i++) {
                int iRemaining = remaining.get(i);
                if (iRemaining > 0) {
                    int p = price.get(i);
                    var newRemaining = new ArrayList<>(remaining);
                    newRemaining.set(i, iRemaining - 1);
                    pq.add(new Pair<>(cost + p, newRemaining));
                }
            }
            // Use special offers
            for (var offer : special) {
                List<Integer> newRemaining = new ArrayList<>();
                for (int i = 0; i < remaining.size(); i++) {
                    int iRemaining = remaining.get(i) - offer.get(i);
                    newRemaining.add(iRemaining);
                }
                if (newRemaining.stream().allMatch(p -> p >= 0)) {
                    pq.add(new Pair<>(cost + offer.get(offer.size() - 1), newRemaining));
                }
            }
        }
    }

    record Pair<A, B>(A left, B right) {
    }
}

