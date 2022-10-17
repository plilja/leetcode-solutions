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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;
        while (current != null) {
            ListNode nextTmp = current.next;
            if (prev.val != current.val) {
                prev.next = current;
                prev = current;
                prev.next = null;
            }
            current = nextTmp;
        }
        return result;
    }
}