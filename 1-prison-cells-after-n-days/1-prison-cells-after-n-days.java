class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> stateToDay = new HashMap<>();
        int day = 0;
        while (day < n) {
            String state = cellsToString(cells);
            if (stateToDay.containsKey(state)) {
                int loop = stateToDay.get(state) - day;
                int remainingDays = n - day;
                day += loop * (remainingDays / loop);
                if (day == n) {
                    break;
                }
            }
            stateToDay.put(cellsToString(cells), day);
            cells = nextDay(cells);
            day++;
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] result = new int[cells.length];
        for (int i = 0; i < cells.length; ++i) {
            int neighbours = 0;
            int neighboursOcc = 0;
            if (i > 0) {
                if (cells[i - 1] == 1) {
                    neighboursOcc++;
                }
                neighbours++;
            }
            if (i < cells.length - 1) {
                if (cells[i + 1] == 1) {
                    neighboursOcc++;
                }
                neighbours++;
            }
            if (neighbours == 2 && List.of(0, 2).contains(neighboursOcc)) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
    
    private String cellsToString(int[] cells) {
        StringBuilder result = new StringBuilder();
        for (int n : cells) {
            result.append(n);
        }
        return result.toString();
    }
}
