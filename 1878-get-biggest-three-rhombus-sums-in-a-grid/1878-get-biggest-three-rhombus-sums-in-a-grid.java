class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> result = new TreeSet<>((a, b) -> b - a);
        for (int y1 = 0; y1 < grid.length; ++y1) {
            for (int x = 0; x < grid[0].length; ++x) {
                for (int y2 = y1; y2 < grid.length; y2 += 2) {
                    int middle = (y2 - y1) / 2;
                    if (x - middle < 0 || x + middle >= grid[0].length) {
                        break;
                    }
                    int sum = grid[y1][x];
                    if (y1 != y2) {
                        sum += grid[y2][x];
                        sum += grid[y1 + middle][x - middle];
                        sum += grid[y1 + middle][x + middle];
                    }
                    for (int d = 1; d < middle; d++) {
                        sum += grid[y1 + d][x + d];
                        sum += grid[y1 + d][x - d];
                        sum += grid[y2 - d][x + d];
                        sum += grid[y2 - d][x - d];
                    }
                    result.add(sum);
                }
            }
        }
        int[] arr = new int[Math.min(3, result.size())];
        int j = 0;
        for (int sum : result) {
            arr[j] = sum;
            j++;
            if (j == 3) {
                break;
            }
        }
        return arr;
    }
}