class Solution {
    fun isRobotBounded(instructions: String): Boolean {
        var delta = Pair(0, 1)
        val startDelta = delta
        var x = 0
        var y = 0
        for (ins in instructions) {
            if (ins == 'L') {
                delta = turnLeft(delta)
            } else if (ins == 'R') {
                delta = turnRight(delta)
            } else if (ins == 'G') {
                val (dx, dy) = delta
                x += dx
                y += dy
            } else {
                throw IllegalArgumentException("Unknown instruction $ins")
            }
        }
        return delta != startDelta || (x == 0 && y == 0)
    }


    private fun turnLeft(delta: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(delta.second, -delta.first)
    }
    
    private fun turnRight(delta: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(-delta.second, delta.first)
    }
}