import java.util.*

class Solution {
    fun reorganizeString(s: String): String {
        val chars = HashMap<Char, Int>()
        for (c in s) {
            chars.merge(c, 1) { a, b -> a + b }
        }
        val pq = PriorityQueue<Pair<Int, Char>> { a, b -> b.first - a.first }
        for ((c, i) in chars) {
            pq.add(Pair(i, c))
        }
        val result = StringBuilder()
        while (pq.isNotEmpty()) {
            val first = pq.poll()
            if (result.isEmpty() || result.last() != first.second) {
                result.append(first.second)
                if (first.first > 1) {
                    pq.add(Pair(first.first - 1, first.second))
                }
            } else {
                if (pq.isEmpty()) {
                    return ""
                }
                val second = pq.poll()
                pq.add(first)
                result.append(second.second)
                if (second.first > 1) {
                    pq.add(Pair(second.first - 1, second.second))
                }
            }
        }
        return result.toString()
    }
}
