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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        int count = 0;
        ListNode result = null;
        ListNode prev = null;
        ListNode curr = head;
        while (count + k <= size) {
            ListNode sectionHead = reverseK(curr, k);
            if (prev != null) {
                prev.next = sectionHead;
            }
            if (result == null) {
                result = sectionHead;
            }
            prev = curr;
            curr = curr.next;
            count += k;
        }
        return result;
    }
    
    private int getSize(ListNode head) {
        int result = 0;
        ListNode current = head;
        while (current != null) {
            result++;
            current = current.next;
        }
        return result;
    }
    
    private ListNode reverseK(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        for (int i = 0; i < k; ++i) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        node.next = curr;
        return prev;
    }
}
