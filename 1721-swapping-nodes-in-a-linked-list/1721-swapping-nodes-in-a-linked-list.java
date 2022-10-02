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
    public ListNode swapNodes(ListNode head, int k) {
        int size = getSize(head);
        int rightIndex = size - k + 1;
        ListNode left = null;
        ListNode right = null;
        int counter = 1;
        ListNode current = head;
        for (int i = 1; i <= Math.max(k, rightIndex); ++i) {
            if (i == k) {
                left = current;
            }
            if (i == rightIndex) {
                right = current;
            }
            current = current.next;
        }
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        return head;
    }
    
    private int getSize(ListNode node) {
        int result = 0;
        ListNode current = node;
        while (current != null) {
            result++;
            current = current.next;
        }
        return result;
    }
}