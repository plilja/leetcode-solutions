class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            throw new IllegalArgumentException("RowIndex must be positive, got " + rowIndex);
        } else if (rowIndex == 0) {
            return List.of(1);
        } else {
            var prev = getRow(rowIndex - 1);
            List<Integer> result = new ArrayList<>();
            result.add(1);
            for (int i = 0; i < prev.size(); i++) {
                int val = prev.get(i);
                if (i + 1 < prev.size()) {
                    val += prev.get(i + 1);
                }
                result.add(val);
            }
            return result;
        }
    }
}
