import kotlin.math.abs

class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        costs.sortBy { c -> -abs(c[0] - c[1]) }
        val n = costs.size
        var cityA = 0
        var cityB = 0
        var result = 0
        for (c in costs) {
            if (c[0] < c[1]) {
                if (cityA < n / 2) {
                    cityA++
                    result += c[0]
                } else {
                    cityB++
                    result += c[1]
                }
            } else {
                if (cityB < n / 2) {
                    cityB++
                    result += c[1]
                } else {
                    cityA++
                    result += c[0]
                }
            }
        }
        return result

    }
}