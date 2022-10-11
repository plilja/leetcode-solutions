class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = 0
        var sum: Long = 0
        var result = 0
        while (right < nums.size) {
            val v = nums[right]
            sum += v
            while (sum + k < v * (right - left + 1)) {
                sum -= nums[left++]
            }
            result = maxOf(result, right - left + 1)
            right++
        }
        return result
    }
}