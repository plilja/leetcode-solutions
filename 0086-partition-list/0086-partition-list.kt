class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var smaller: ListNode? = null
        var smallerHead: ListNode? = null
        var greater: ListNode? = null
        var greaterHead: ListNode? = null
        var current = head
        while (current != null) {
            if (current.`val` < x) {
                if (smaller == null) {
                    smaller = current
                    smallerHead = current
                } else {
                    smaller.next = current
                    smaller = current
                }
            } else {
                if (greater == null) {
                    greater = current
                    greaterHead = current
                } else {
                    greater.next = current
                    greater = current
                }
            }
            val tmpNext = current.next
            current.next = null
            current = tmpNext
        }

        if (smaller != null) {
            smaller.next = greaterHead
            return smallerHead
        } else {
            return greaterHead
        }
    }
}