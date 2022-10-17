import java.util.*;

class StockPrice {
    private final TreeMap<Integer, Set<Integer>> pricesSorted = new TreeMap<>();
    private final Map<Integer, Integer> pricesAtTime = new HashMap<>();
    private int maxTimestamp = -1;
    private int currentPrice = 0;

    public StockPrice() {
    }
    
    public void update(int timestamp, int price) {
        Integer oldPrice = pricesAtTime.get(timestamp);
        if (oldPrice != null) {
            Set<Integer> timestampsWithOldPrice = pricesSorted.get(oldPrice);
            timestampsWithOldPrice.remove(timestamp);
            if (timestampsWithOldPrice.isEmpty()) {
                pricesSorted.remove(oldPrice);
            }
        }
        pricesAtTime.put(timestamp, price);
        pricesSorted.computeIfAbsent(price, k -> new HashSet<>()).add(timestamp);
        if (timestamp >= maxTimestamp) {
            maxTimestamp = timestamp;
            currentPrice = price;
        }
    }
    
    public int current() {
        if (pricesSorted.isEmpty()) {
            throw new NoSuchElementException();
        }
        return currentPrice;
    }
    
    public int maximum() {
        if (pricesSorted.isEmpty()) {
            throw new NoSuchElementException();
        }
        return pricesSorted.lastKey();
        
    }
    
    public int minimum() {
        if (pricesSorted.isEmpty()) {
            throw new NoSuchElementException();
        }
        return pricesSorted.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
