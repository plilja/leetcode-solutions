private val DELTAS = listOf(
    Pair(1, 0),
    Pair(0, 1),
    Pair(-1, 0),
    Pair(0, -1)
)

class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val results = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }
        var result = 0
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                val sub = dfs(matrix, x, y, results)
                result = maxOf(result, sub)
            }
        }
        return result
    }

    private fun dfs(matrix: Array<IntArray>, x: Int, y: Int, results: Array<IntArray>): Int {
        if (results[y][x] != -1) {
            return results[y][x]
        }
        val v = matrix[y][x]
        var result = 1
        for ((dx, dy) in DELTAS) {
            if (0 > x + dx || x + dx >= matrix[0].size) {
                continue
            }
            if (0 > y + dy || y + dy >= matrix.size) {
                continue
            }
            if (matrix[y + dy][x + dx] < v) {
                val sub = dfs(matrix, x + dx, y + dy, results) + 1
                result = maxOf(result, sub)
            }
        }
        results[y][x] = result
        return result
    }
}