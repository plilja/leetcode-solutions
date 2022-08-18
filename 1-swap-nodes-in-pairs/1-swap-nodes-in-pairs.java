/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode result = head.next;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode nextNextTmp = current.next.next;
            if (prev != null) {
                prev.next = current.next;
            }
            current.next.next = current;
            current.next = nextNextTmp;
            prev = current;
            current = nextNextTmp;
        }
        return result;
    }
}
