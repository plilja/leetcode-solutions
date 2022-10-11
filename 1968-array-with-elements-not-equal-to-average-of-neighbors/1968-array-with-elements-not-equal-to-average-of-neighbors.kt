class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        nums.sort()
        val result = IntArray(nums.size)
        var left = 0
        var right = nums.size - 1
        var i = 0
        while (i < nums.size) {
            result[i++] = nums[left++]
            if (i < nums.size) {
                result[i++] = nums[right--]
            }
        }
        return result
    }
}