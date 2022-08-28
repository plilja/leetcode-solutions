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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode result;
        ListNode current1;
        ListNode current2;
        if (list1.val < list2.val) {
            result = list1;
            current1 = list1.next;
            current2 = list2;
        } else {
            result = list2;
            current1 = list1;
            current2 = list2.next;
        }
        ListNode currentResult = result;
        while (current1 != null || current2 != null) {
            if (current1 == null) {
                currentResult.next = current2;
                break;
            }
            if (current2 == null) {
                currentResult.next = current1;
                break;
            }
            if (current1.val < current2.val) {
                currentResult.next = current1;
                current1 = current1.next;
            } else {
                currentResult.next = current2;
                current2 = current2.next;
            }
            currentResult = currentResult.next;
        }
        return result;
    }
}
