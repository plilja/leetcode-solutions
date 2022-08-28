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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head); 
        if (n == size) {
            return head.next;
        } else {
            int itemToRemove = size - n;
            remove(head, itemToRemove);
            return head;
        }
    }
    
    private int getSize(ListNode node) {
        ListNode current = node;
        int result = 0;
        while (current != null) {
            result++;
            current = current.next;
        }
        return result;
    }
    
    private void remove(ListNode head, int index) {
        int count = 0;
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; i < index; ++i) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }
    
    
}
