class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var xLeft = 0
        var xRight = matrix[0].size - 1
        var yTop = 0
        var yBottom = matrix.size - 1
        val result = ArrayList<Int>()
        while (xLeft <= xRight && yTop <= yBottom) {
            for (x in xLeft..xRight) {
                result.add(matrix[yTop][x])
            }
            if (yTop == yBottom) {
                break
            }
            for (y in yTop + 1..yBottom) {
                result.add(matrix[y][xRight])
            }
            if (xLeft == xRight) {
                break
            }
            for (x in xRight - 1 downTo xLeft) {
                result.add(matrix[yBottom][x])
            }
            for (y in yBottom - 1 downTo yTop + 1) {
                result.add(matrix[y][xLeft])
            }
            yTop++
            xRight--
            yBottom--
            xLeft++
        }
        return result
    }
}