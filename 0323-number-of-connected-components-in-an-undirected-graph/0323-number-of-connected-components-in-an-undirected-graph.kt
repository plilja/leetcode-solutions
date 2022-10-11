class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = HashMap<Int, MutableSet<Int>>()
        for (i in 0 until n) {
            graph[i] = HashSet()
        }
        for (edge in edges) {
            val (a, b) = edge
            graph[a]?.add(b)
            graph[b]?.add(a)
        }
        var result = 0
        val visited = HashSet<Int>()
        for (i in 0 until n) {
            if (i !in visited) {
                result++
                val q = ArrayDeque<Int>()
                q.addLast(i)
                while (q.isNotEmpty()) {
                    val p = q.removeFirst()
                    if (p in visited) {
                        continue
                    }
                    visited.add(p)
                    for (neighbour in graph[p]!!) {
                        q.addLast(neighbour)
                    }
                }
            }
            
        }
        return result
    }
}