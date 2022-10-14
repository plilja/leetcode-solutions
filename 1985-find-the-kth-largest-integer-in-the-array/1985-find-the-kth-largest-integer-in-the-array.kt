import java.math.BigInteger
import java.util.*

class Solution {
    private val random = Random()

    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        return solve(nums.map { BigInteger(it) }.toTypedArray(), 0, nums.size - 1, nums.size - k)
    }

    private fun solve(nums: Array<BigInteger>, left: Int, right: Int, n: Int): String {
        val pivotIdx = left + random.nextInt(right + 1 - left)
        val newPivotIdx = partition(nums, left, right, pivotIdx)
        if (newPivotIdx == n) {
            return nums[newPivotIdx].toString()
        } else if (newPivotIdx >= n) {
            return solve(nums, left, newPivotIdx, n)
        } else {
            return solve(nums, newPivotIdx + 1, right, n)
        }
    }

    private fun partition(nums: Array<BigInteger>, left: Int, right: Int, pivotIdx: Int): Int {
        val pivot = nums[pivotIdx]
        var store = left
        swap(nums, right, pivotIdx)
        for (i in left until right) {
            if (nums[i] < pivot) {
                swap(nums, store, i)
                store++
            }
        }
        swap(nums, store, right)
        return store
    }

    private fun swap(nums: Array<BigInteger>, a: Int, b: Int) {
        val aTmp = nums[a]
        nums[a] = nums[b]
        nums[b] = aTmp
    }
}
