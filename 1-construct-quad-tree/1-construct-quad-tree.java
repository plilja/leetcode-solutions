/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructHelper(grid, 0, grid[0].length, 0, grid.length);
    }
    
    private Node constructHelper(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        int first = grid[yStart][xStart];
        boolean allSame = true;
        for (int y = yStart; y < yEnd && allSame; ++y) {
            for (int x = xStart; x < xEnd; ++x) {
                int value = grid[y][x];
                if (first != value) {
                    allSame = false;
                    break;
                }
            }
        }
        if (allSame) {
            return new Node(first == 1, true);
        } else {
            int diff = xEnd - xStart;
            int middle = diff / 2;
            Node topLeft = constructHelper(grid, xStart, xStart + middle, yStart, yStart + middle);
            Node topRight = constructHelper(grid, xStart + middle, xEnd, yStart, yStart + middle);
            Node bottomLeft = constructHelper(grid, xStart, xStart + middle, yStart + middle, yEnd);
            Node bottomRight = constructHelper(grid, xStart + middle, xEnd, yStart + middle, yEnd);
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
