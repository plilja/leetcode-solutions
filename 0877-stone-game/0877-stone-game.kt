class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        val prefixSum = IntArray(piles.size)
        var acc = 0
        for ((i, v) in piles.withIndex()) {
            acc += v
            prefixSum[i] = acc
        }

        // dp[left][right]
        // if right - left is odd => best points Alice can get given that only piles between left and right are left
        // if right - left is even => best points Bob can get given that only piles between left and right are left
        val dp = Array(piles.size) { IntArray(piles.size) }
        for (interval in 0 until piles.size) {
            for (left in 0 until (piles.size - interval)) {
                val right = left + interval
                if (left == right) {
                    dp[left][right] = piles[left]
                } else {
                    var sumInRange = prefixSum[right]
                    if (left > 0) {
                        sumInRange -= prefixSum[left - 1]
                    }
                    val leftPick = sumInRange - dp[left + 1][right]
                    val rightPick = sumInRange - dp[left][right - 1]
                    dp[left][right] = maxOf(leftPick, rightPick)
                }
            }
        }
        return dp[0][piles.size - 1] > prefixSum[piles.size - 1] / 2
    }
}