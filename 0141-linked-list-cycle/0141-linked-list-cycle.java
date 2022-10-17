/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            quick = quick.next;
            if (quick == null) {
                break;
            }
            quick = quick.next;
            slow = slow.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }
}
