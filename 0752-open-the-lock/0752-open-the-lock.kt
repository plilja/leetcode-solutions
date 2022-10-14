class Solution {
    fun openLock(deadendsArr: Array<String>, target: String): Int {
        val visited = HashSet<String>()
        val deadends = HashSet<String>()
        deadendsArr.forEach { deadends.add(it) }
        val q = ArrayDeque<Pair<String, Int>>()
        q.add(Pair("0000", 0));
        visited.add("0000")
        while (q.isNotEmpty()) {
            val s = q.removeFirst()
            if (s.first in deadends) {
                continue
            }
            if (s.first == target) {
                return s.second
            }
            for (neighbour in getNeighbours(s.first)) {
                if (neighbour !in visited) {
                    visited.add(neighbour)
                    q.add(Pair(neighbour, s.second + 1))
                }
            }
        }
        return -1
    }

    private fun getNeighbours(s: String): List<String> {
        val result = ArrayList<String>()
        for (i in 0..3) {
            val c = s[i] - '0'
            val a = '0' + ((c + 1) % 10)
            val b = '0' + ((c + 9) % 10)
            result.add(s.substring(0, i) + a + s.substring(i + 1, s.length))
            result.add(s.substring(0, i) + b + s.substring(i + 1, s.length))
        }
        return result
    }
}
