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
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = null;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            if (current.val == val) {
                if (prev != null) {
                    prev.next = current.next;
                }
            } else {
                if (result == null) {
                    result = current;
                }
                prev = current;
            }
            current = current.next;
        }
        return result;
    }
}
