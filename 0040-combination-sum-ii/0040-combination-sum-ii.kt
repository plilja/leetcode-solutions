class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        candidates.sort()
        solve(candidates, 0, target, ArrayList(), result)
        return result
    }

    fun solve(candidates: IntArray, start: Int, target: Int, current: MutableList<Int>, result: MutableList<List<Int>>) {
        if (target == 0) {
            result.add(ArrayList(current))
        } else if (start < candidates.size) {
            val v = candidates[start]
            if (v <= target) {
                current.add(v)
                solve(candidates, start + 1, target - v, current, result)
                current.removeAt(current.size - 1)
            }
            var nextIndex = start + 1
            while (nextIndex < candidates.size && candidates[nextIndex] == v) {
                nextIndex ++
            }
            solve(candidates, nextIndex, target, current, result)
        }
    }
}