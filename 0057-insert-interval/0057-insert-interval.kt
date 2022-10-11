class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = ArrayList<IntArray>()
        var added = false
        var i = 0
        while (i < intervals.size) {
            val next : IntArray
            if (!added && intervals[i][1] >= newInterval[0]) {
                next = newInterval
                added = true
            } else {
                next = intervals[i]
                i++
            }
            if (result.isNotEmpty() && overlaps(result.last(), next)) {
                val (from1, to1) = result.last()
                val (from2, to2) = next
                result[result.size - 1] = intArrayOf(minOf(from1, from2), maxOf(to1, to2))
            } else {
                result.add(next)
            }
        }
        if (!added) {
            result.add(newInterval)
        }
        return result.toTypedArray()
    }

    private fun overlaps(a: IntArray, b: IntArray): Boolean {
        if (a[0] <= b[0] && a[1] >= b[0]) {
            return true
        }
        if (b[0] <= a[0] && b[1] >= a[0]) {
            return true
        }
        return false
    }
}
