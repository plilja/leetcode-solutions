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
        ListNode l1Reversed = reverse(l1);
        ListNode l2Reversed = reverse(l2);
        ListNode l1Current = l1Reversed;
        ListNode l2Current = l2Reversed;
        ListNode result = null;
        ListNode resultCurrent = null;
        int carry = 0;
        while (l1Current != null || l2Current != null) {
            int val = carry;
            if (l1Current != null) {
                val += l1Current.val;
                l1Current = l1Current.next;
            }
            if (l2Current != null) {
                val += l2Current.val;
                l2Current = l2Current.next;
            }
            ListNode next = new ListNode(val % 10);
            carry = val / 10;
            if (result == null) {
                result = next;
            } else {
                resultCurrent.next = next;
            }
            resultCurrent = next;
        }
        if (carry != 0) {
            ListNode next = new ListNode(carry);
            resultCurrent.next = next;
            resultCurrent = next;
        }
        reverse(l1Reversed);
        reverse(l2Reversed);
        return reverse(result);
    }
    
    private ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = prev;
            prev = current;
            current = nextTmp;
        }
        return prev;
    }
}
