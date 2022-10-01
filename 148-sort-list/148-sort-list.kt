/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head != null) {
            return mergesort(head)
        } else {
            return null
        }
    }

    fun mergesort(node: ListNode): ListNode {
        val size = getSize(node)
        if (size == 1) {
            return node
        }
        var (firstHalf, secondHalf) = split(node, size / 2)
        firstHalf = mergesort(firstHalf!!)
        secondHalf = mergesort(secondHalf!!)
        var result: ListNode? = null
        var resultCurrent: ListNode? = null
        if (firstHalf.`val` < secondHalf.`val`) {
            result = firstHalf
            resultCurrent = firstHalf
            firstHalf = firstHalf.next
        } else {
            result = secondHalf
            resultCurrent = secondHalf
            secondHalf = secondHalf.next
        }
        while (firstHalf != null || secondHalf != null) {
            if (firstHalf != null && secondHalf != null) {
                if (firstHalf.`val` < secondHalf.`val`) {
                    resultCurrent!!.next = firstHalf
                    firstHalf = firstHalf.next
                } else {
                    resultCurrent!!.next = secondHalf
                    secondHalf = secondHalf.next
                }
            } else if (firstHalf != null) {
                resultCurrent!!.next = firstHalf
                firstHalf = firstHalf.next
            } else {
                resultCurrent!!.next = secondHalf
                secondHalf = secondHalf!!.next
            }
            resultCurrent = resultCurrent!!.next
        }
        return result!!
    }

    fun split(node: ListNode, at: Int): Pair<ListNode?, ListNode?> {
        var current: ListNode? = node
        var prev: ListNode? = null
        var index = 0
        while (index < at) {
            index++
            prev = current
            current = current!!.next
        }
        prev!!.next = null
        return Pair(node, current)
    }
    
    fun getSize(node: ListNode): Int {
        var current: ListNode? = node
        var size = 0
        while (current != null) {
            size++
            current = current.next
        }
        return size
    }

}