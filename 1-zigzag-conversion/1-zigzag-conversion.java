class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int j = 0; j < numRows; ++j) {
            rows.add(new StringBuilder());
        }
        int delta = 1;
        int currentRow = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            rows.get(currentRow).append(c);
            if (currentRow == 0 && delta == -1) {
                currentRow++;
                delta = 1;
            } else if (currentRow == numRows - 1 && delta == 1) {
                currentRow--;
                delta = -1;
            } else {
                currentRow += delta;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
