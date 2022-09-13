class SnakeGame {
    private static final Map<String, Point> DIRECTIONS = Map.of(
        "R", new Point(1, 0),
        "D", new Point(0, 1),
        "L", new Point(-1, 0),
        "U", new Point(0, -1)
    );
    
    private final Deque<Point> body = new ArrayDeque<>();
    private final int width;
    private final int height;
    private final Deque<Point> foods;
    private int score = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        body.add(new Point(0, 0));
        foods = new ArrayDeque<>();
        for (int[] f : food) {
            foods.add(new Point(f[1], f[0]));
        }
    }
    
    public int move(String direction) {
        Point head = body.peekLast();
        if (head == null) {
            throw new IllegalStateException("No body");
        }
        Point delta = DIRECTIONS.get(direction);
        if (delta == null) {
            throw new IllegalArgumentException("Invalid direction " + delta);
        }
        Point nextPoint = new Point(head.x() + delta.x(), head.y() + delta.y());
        if (!foods.isEmpty() && foods.peekFirst().equals(nextPoint)) {
            foods.pollFirst();
            score++;
        } else {
            body.pollFirst();
            if (body.contains(nextPoint)) {
                return -1; // ran into our tail
            }
            boolean xValid = nextPoint.x() >= 0 && nextPoint.x() < width;
            boolean yValid = nextPoint.y() >= 0 && nextPoint.y() < height;
            if (!xValid || !yValid) {
                return -1; // out of bounds
            }
        }
        body.add(nextPoint);
        return score;
    }
    
    private record Point(int x, int y) {
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
