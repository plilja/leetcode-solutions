private val MOD = 1000000007

class Solution {
    fun numSubseq(nums: IntArray, target: Int): Int {
        nums.sort()
        var left = nums.size - 1;
        var result = 0L
        for ((right, rightValue) in nums.withIndex()) {
            while (left >= 0 && rightValue + nums[left] > target) {
                left--
            }
            if (left >= right) {
                result += pow(2L, right.toLong())
            } else if (left >= 0) {
                val leftPicks = pow(2L, left.toLong() + 1L) - 1
                val midPicks = pow(2L, (right - left - 1).toLong())
                result += leftPicks * midPicks
            } 
            result %= MOD
        }
        return result.toInt()
    }

    private fun pow(n: Long, k: Long): Long {
        if (k == 0L) {
            return 1L
        } else if (k % 2L == 0L) {
            val r = pow(n, k / 2)
            return r * r % MOD
        } else {
            return n * pow(n, k - 1) % MOD
        }
    }
}