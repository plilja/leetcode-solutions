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
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = head;
        ListNode unsorted = head.next;
        sorted.next = null;
        while (unsorted != null) {
            ListNode elem = unsorted;
            unsorted = unsorted.next;
            sorted = insert(sorted, elem);
        }
        return sorted;
    }
    
    private ListNode insert(ListNode head, ListNode elem) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.val <= elem.val) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.next = elem;
        }
        elem.next = curr;
        if (prev == null) {
            // Elem should go before all other elements, i.e. it's the new head
            return elem;
        } else {
            return head;
        }
            
    }
}