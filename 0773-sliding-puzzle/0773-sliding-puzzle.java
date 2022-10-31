class Solution {
    private static final Map<Integer, List<Integer>> MOVES = Map.of(
            0, List.of(1, 3),
            1, List.of(0, 2, 4),
            2, List.of(1, 5),
            3, List.of(0, 4),
            4, List.of(1, 3, 5),
            5, List.of(2, 4)
    );

    public int slidingPuzzle(int[][] boardMatrix) {
        String startBoard = "";
        for (int y = 0; y < 2; ++y) {
            for (int x = 0; x < 3; ++x) {
                startBoard += boardMatrix[y][x];
            }
        }
        Set<String> visited = new HashSet<>();
        Deque<String> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        q1.add(startBoard);
        q2.add(0);
        while (!q1.isEmpty()) {
            String board = q1.poll();
            int dist = q2.poll();
            if ("123450".equals(board)) {
                return dist;
            }
            if (visited.contains(board)) {
                continue;
            }
            visited.add(board);
            int zero = board.indexOf('0');
            for (int m : MOVES.get(zero)) {
                char[] boardArr = board.toCharArray();
                swap(boardArr, m, zero);
                q1.add(new String(boardArr));
                q2.add(dist + 1);
            }
        }
        return -1;
    }

    private void swap(char[] arr, int a, int b) {
        char aTmp = arr[a];
        arr[a] = arr[b];
        arr[b] = aTmp;
    }
}
