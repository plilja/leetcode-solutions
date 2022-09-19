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
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int middle = size / 2;
        return getNthNode(head, middle);
    }
    
    private ListNode getNthNode(ListNode head, int n) {
        ListNode current = head;
        int counter = 0;
        while (current != null && counter < n) {
            current = current.next;
            counter++;
        }
        return current;
    }
    
    private int getSize(ListNode head) {
        ListNode current = head;
        int result = 0;
        while (current != null) {
            current = current.next;
            result++;
        }
        return result;
    }
}
