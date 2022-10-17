class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (i in 0..coins.size - 1) {
            val coin = coins[i]
            for (j in coin..amount) {
                dp[j] += dp[j - coin]
            }
        }
        return dp[amount]
    }
}