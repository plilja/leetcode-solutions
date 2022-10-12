class Solution {
    fun addBinary(a: String, b: String): String {
        val result = StringBuilder()
        var carry = 0
        for (i in 0 until maxOf(a.length, b.length)) {
            var d1 = 0
            if (i < a.length) {
                d1 = a[a.length - i - 1] - '0'
            }
            var d2 = 0
            if (i < b.length) {
                d2 = b[b.length - i - 1] - '0'
            }
            val d = d1 + d2 + carry
            result.append(d % 2)
            carry = d / 2
        }
        if (carry > 0) {
            result.append(carry)
        }
        result.reverse()
        return result.toString()
    }
}