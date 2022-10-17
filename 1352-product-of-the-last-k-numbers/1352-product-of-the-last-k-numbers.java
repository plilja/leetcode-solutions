/*
[3,0,2,5,4]
k = 1 => 4
k = 2 => 20
k = 3 => 40
k >= 4 => 0


[40, 20, 4]
2, 10, 40
*/

class ProductOfNumbers {
    private final List<Integer> products = new ArrayList<>();

    public ProductOfNumbers() {
    }
    
    public void add(int num) {
        if (num == 0) {
            products.clear();
        } else if (products.isEmpty()) {
            products.add(num);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if (k > products.size()) {
            return 0;
        } else {
            int result = products.get(products.size() - 1);
            if (k < products.size()) {
                result /= products.get(products.size() - k - 1);
            }
            return result;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
