class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val graph = Array<MutableSet<Int>>(n) { HashSet() }
        for ((a, b) in edges) {
            graph[a].add(b)
            graph[b].add(a)
        }
        val visited = HashSet<Int>()
        val q = ArrayDeque<Int>()
        q.addLast(0)
        while (!q.isEmpty()) {
            val node = q.removeFirst()
            if (node in visited) {
                return false
            }
            visited.add(node)
            for (neighbour in graph[node]) {
                graph[neighbour].remove(node)
                q.addLast(neighbour)
            }
        }
        return visited.size == n
    }
}