class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = ArrayList<List<Int>>()
        solve(nums, 0, ArrayList(), result)
        return result
    }

    private fun solve(nums: IntArray, i: Int, current: MutableList<Int>, result: MutableList<List<Int>>) {
        if (nums.size == i) {
            result.add(ArrayList(current))
        } else {
            val v = nums[i]
            current.add(v)
            solve(nums, i + 1, current, result)
            current.removeAt(current.size - 1)
            var nextIndex = i
            while (nextIndex < nums.size && nums[nextIndex] == v) {
                nextIndex++
            }
            solve(nums, nextIndex, current, result)
        }
    }
}

