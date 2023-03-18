class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        TreeMap<Integer, Integer> boxToCount = new TreeMap<>();
        for (int box : boxes) {
            boxToCount.merge(box, 1, (a, b) -> a + b);
        }
        TreeMap<Integer, Integer> warehouseToCount = new TreeMap<>();
        for (int h : warehouse) {
            warehouseToCount.merge(h, 1, (a, b) -> a + b);
        }
        int result = 0;
        for (int i = warehouse.length - 1; i >= 0; --i) {
            int h = warehouse[i];
            var bound = warehouseToCount.firstEntry();
            var box = boxToCount.floorEntry(bound.getKey());
            if (box != null) {
                if (box.getValue() == 1) {
                    boxToCount.remove(box.getKey());
                } else {
                    boxToCount.put(box.getKey(), box.getValue() - 1);
                }
                result++;
            }
            int count = warehouseToCount.merge(h, -1, (a, b) -> a + b);
            if (count == 0) {
                warehouseToCount.remove(h);
            }
        }
        return result;
    }
}
