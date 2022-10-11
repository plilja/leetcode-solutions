import java.lang.Math.abs
import java.util.PriorityQueue

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val pq = PriorityQueue<Int>({ a, b ->
            if (abs(a - x) != abs(b - x)) {
                abs(a - x) - abs(b - x)
            } else {
                a - b
            }
        })
        for (n in arr) {
            pq.add(n)
        }
        val result = ArrayList<Int>()
        while (result.size < k && pq.isNotEmpty()) {
            result.add(pq.poll())
        }
        result.sort()
        return result
    }
}