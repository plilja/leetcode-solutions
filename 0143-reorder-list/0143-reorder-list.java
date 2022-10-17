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
    public void reorderList(ListNode head) {
        int n = size(head);
        int middle = (n + 1) / 2;
        ListNode tail = cutAfter(head, middle);
        ListNode tailReversed = reverse(tail);
        interleave(head, tailReversed);
    }
    
    private int size(ListNode head) {
        ListNode current = head;
        int result = 0;
        while (current != null) { 
            current = current.next;
            result++;
        }
        return result;
    }
    
    private ListNode cutAfter(ListNode head, int num) {
        if (num == 0) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
        while (count < num) { 
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = null;
        return current;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = prev;
            prev = current;
            current = nextTmp;
        }
        return prev;
    }
    
    private ListNode interleave(ListNode a, ListNode b) {
        ListNode resultCurrent = a;
        ListNode currentA = a.next;
        ListNode currentB = b;
        while (currentA != null || currentB != null) {
            if (currentB != null) {
                resultCurrent.next = currentB;
                resultCurrent = currentB;
                currentB = currentB.next;
            }
            if (currentA != null) {
                resultCurrent.next = currentA;
                resultCurrent = currentA;
                currentA = currentA.next;
            }
        }
        return a;
    }
}
