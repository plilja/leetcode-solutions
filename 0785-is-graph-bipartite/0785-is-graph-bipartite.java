class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean result = true;
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; ++i) {
            result = result && twoColor(graph, colors, i, -1);
        }
        return result;
    }
    
    public boolean twoColor(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] != -1) {
            return color == -1 || colors[i] == color;
        }
        if (color == -1) {
            colors[i] = 0;
        } else {
            colors[i] = color;
        }
        boolean result = true;
        for (int neighbour : graph[i]) {
            int otherColor = (colors[i] + 1) % 2;
            result = result && twoColor(graph, colors, neighbour, otherColor);
        }
        return result;
    }
}