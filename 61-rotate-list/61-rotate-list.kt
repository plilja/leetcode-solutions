class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        val size = getSize(head)
        val rotate = k % size
        if (rotate == 0) {
            return head
        } else {
            val tail = splitAt(head, size - rotate)
            return concat(tail, head)
        }
    }

    private fun getSize(head: ListNode): Int {
        var current: ListNode? = head
        var result = 0
        while (current != null) {
            result++
            current = current.next
        }
        return result
    }

    private fun splitAt(head: ListNode, position: Int): ListNode {
        var prev: ListNode? = null
        var current: ListNode = head
        var counter = 0
        while (counter < position) {
            counter++
            prev = current
            current = current.next!!
        }
        prev?.next = null
        return current
    }

    private fun concat(list1: ListNode, list2: ListNode): ListNode {
        var list1Current = list1
        while (list1Current.next != null) {
            list1Current = list1Current.next!!
        }
        list1Current.next = list2
        return list1
    }
}
