class Solution {
    private static final int BIG = 1000000;
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < arr2.length; ++i) {
            order.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : arr1) {
            list.add(n);
        }
        list.sort((a, b) -> {
            int order1 = order.getOrDefault(a, BIG);
            int order2 = order.getOrDefault(b, BIG);
            if (order1 != order2) {
                return order1 - order2;
            } else {
                return a - b;
            }
        });
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}