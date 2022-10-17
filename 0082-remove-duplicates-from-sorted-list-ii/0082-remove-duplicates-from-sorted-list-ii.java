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
        ListNode result = null;
        ListNode prevUniq = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current;
            int val = next.val; 
            current = current.next;
            boolean uniq = true;
            while (current != null && current.val == val) {
                current = current.next;
                uniq = false;
            }
            if (uniq) {
                if (result == null) {
                    result = next;
                }
                if (prevUniq != null) {
                    prevUniq.next = next;
                }
                prevUniq = next;
                prevUniq.next = null;
            }
            
        }
        return result;
    }
}