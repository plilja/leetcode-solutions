class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { i -> i[0] }
        var prev = intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE)
        var result = 0
        for (i in 0 until intervals.size) {
            val interval = intervals[i]
            if (overlaps(prev, interval)) {
                result++
                if (prev[1] > interval[1]) {
                    prev = interval
                }
            } else {
                prev = interval
            }
        }
        return result
    }

    private fun overlaps(a: IntArray, b : IntArray) : Boolean {
        if (a[0] <= b[0] && a[1] > b[0]) {
            return true
        }
        if (b[0] <= a[0] && b[1] > a[0]) {
            return true
        }
        return false
    }
}