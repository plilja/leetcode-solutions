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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int memory = 0;
        while (l1 != null || l2 != null) {
            int value = memory;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(value % 10);
            memory = value / 10;
            if (result == null) {
                result = newNode;
            }
            if (current != null) {
                current.next = newNode;
            }
            current = newNode;
        }
        if (memory > 0) {
            ListNode newNode = new ListNode(memory % 10);
            current.next = newNode;
        }
        return result;
    }
}
