typealias Point = Pair<Int, Int>

private val DELTAS = listOf(
    Point(1, 0),
    Point(0, 1),
    Point(-1, 0),
    Point(0, -1)
)

class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        for (y in heights.indices) {
            for (x in heights[y].indices) {
                val visited = HashSet<Point>()
                val q = ArrayDeque<Point>()
                q.addLast(Point(x, y))
                var flowsToPacific = false
                var flowsToAtlantic = false
                while (q.isNotEmpty()) {
                    val p = q.removeFirst()
                    if (p in visited) {
                        continue
                    }
                    visited.add(p)
                    for ((dx, dy) in DELTAS) {
                        val n = Point(p.first + dx, p.second + dy)
                        if (n.first < 0 || n.second < 0) {
                            flowsToPacific = true
                            continue
                        }
                        if (n.first == heights[0].size || n.second == heights.size) {
                            flowsToAtlantic = true
                            continue
                        }
                        if (heights[p.second][p.first] >= heights[n.second][n.first]) {
                            q.addLast(n)
                        }
                    }
                }
                if (flowsToPacific && flowsToAtlantic) {
                    result.add(listOf(y, x))
                }
            }
        }
        return result
    }
}