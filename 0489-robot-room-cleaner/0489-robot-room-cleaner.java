/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        visit(robot, new Point(0, 0), new Point(1, 0), new HashSet<>(), new ArrayDeque<>());
    }
    
    private void visit(Robot robot, Point p, Point delta, Set<Point> visited, Deque<Point> breadcrumbs) {
        robot.clean();
        visited.add(p);
        Point currDelta = delta;
        for (int i = 0; i < 4; ++i) {
            robot.turnRight();
            currDelta = turnRight(currDelta);
            Point next = new Point(p.x() + currDelta.x(), p.y() + currDelta.y());
            if (!visited.contains(next) && robot.move()) {
                breadcrumbs.add(currDelta);
                visit(robot, next, currDelta, visited, breadcrumbs);
            }
        }
        if (!breadcrumbs.isEmpty()) {
            // Set robot direction to inverse of how it was when we came to this square
            Point cameFrom = breadcrumbs.pollLast();
            while (!currDelta.equals(negate(cameFrom))) {
                robot.turnRight();
                currDelta = turnRight(currDelta);
            }
            robot.move();
            // Reset robot direction to how it was when we came to this square
            while (!currDelta.equals(cameFrom)) {
                robot.turnRight();
                currDelta = turnRight(currDelta);
            }
        }
    }
    
    private Point turnRight(Point delta) {
        return new Point(-delta.y(), delta.x());
        
    }
    
    private Point negate(Point delta) {
        return new Point(-delta.x(), -delta.y());
    }
    
    record Point(int x, int y) {
    }
}