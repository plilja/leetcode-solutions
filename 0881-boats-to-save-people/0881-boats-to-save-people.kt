class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var result = 0
        var left = -1
        var right = people.size
        while (left + 1 < right) {
            val p = people[--right]
            if (left + 1 < right && people[left + 1] + p <= limit) {
                // We fit one person of lesser weight on the same life boat?
                left++
            }
            result++
        }
        return result
    }
}