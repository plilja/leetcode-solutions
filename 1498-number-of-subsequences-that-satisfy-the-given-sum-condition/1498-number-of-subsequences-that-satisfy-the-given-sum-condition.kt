private val MOD = 1000000007

class Solution {
    fun numSubseq(nums: IntArray, target: Int): Int {
        nums.sort()
        var right = nums.size - 1;
        var result = 0L
        for ((left, leftValue) in nums.withIndex()) {
            while (right >= left && leftValue + nums[right] > target) {
                right--
            }
            if (right < left) {
                break
            }
            result += pow(2L, (right - left).toLong())
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