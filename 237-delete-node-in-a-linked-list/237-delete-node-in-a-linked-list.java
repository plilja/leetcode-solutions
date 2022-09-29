/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        while (current != null) {
            if (current.next != null) {
                current.val = current.next.val;
            } else {
                prev.next = null;
            }
            prev = current;
            current = current.next;
        }
    }
}