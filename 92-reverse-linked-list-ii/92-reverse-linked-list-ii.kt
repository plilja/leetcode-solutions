class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head
        for (i in 1 until left) {
            prev = curr
            curr = curr?.next
        }
        val cutLeft = prev
        val firstReverse = curr
        for (i in 0..(right - left)) {
            val nextTmp = curr?.next
            curr?.next = prev
            prev = curr
            curr = nextTmp
        }
        cutLeft?.next = prev
        firstReverse?.next = curr
        if (left == 1) {
            return prev
        } else {
            return head
        }
    }
}
