class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val result = ArrayList<Int>()
        val movingRight = ArrayDeque<Int>()
        for (asteroid in asteroids) {
            if (asteroid > 0) {
                movingRight.addLast(asteroid)
            } else {
                while (!movingRight.isEmpty() && movingRight.last() < -asteroid) {
                    movingRight.removeLast()
                }
                if (movingRight.isEmpty()) {
                    result.add(asteroid)
                } else if (movingRight.last() == -asteroid) {
                    movingRight.removeLast()
                }
            }
        }
        result.addAll(movingRight)
        return result.toIntArray()
    }
}