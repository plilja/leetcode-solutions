class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }
        dp[text1.length][text2.length] = 0
        for (i in text1.length - 1 downTo 0) {
            val c1 = text1[i]
            for (j in text2.length - 1 downTo 0) {
                val c2 = text2[j]
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j + 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i][j + 1], dp[i + 1][j])
                }
            }
        }
        return dp[0][0]
    }
}
