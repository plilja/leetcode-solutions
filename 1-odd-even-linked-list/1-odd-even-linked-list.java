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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode oddTail = null;
        ListNode evenTail = null;
        ListNode oddCurrent = head;
        ListNode evenCurrent = head != null ? head.next : null;
        
        while (oddCurrent != null || evenCurrent != null) {
            if (oddHead == null) {
                oddHead = oddCurrent;
                oddTail = oddCurrent;
                oddCurrent = stepTwo(oddCurrent);
            } else {
                if (oddCurrent != null) {
                    oddTail.next = oddCurrent;
                    oddTail = oddCurrent;
                    oddCurrent = stepTwo(oddCurrent);
                }
            }
            if (evenHead == null) {
                evenHead = evenCurrent;
                evenTail = evenCurrent;
                evenCurrent = stepTwo(evenCurrent);
            } else {
                if (evenCurrent != null) {
                    evenTail.next = evenCurrent;
                    evenTail = evenCurrent;
                    evenCurrent = stepTwo(evenCurrent);
                }
            }
            if (oddTail != null) {
                oddTail.next = null;
            }
            if (evenTail != null) {
                evenTail.next = null;
            }
        }
        if (oddTail != null) {
            oddTail.next = evenHead;
        }
        return oddHead;
    }
    
    private ListNode stepTwo(ListNode node) {
        if (node != null && node.next != null) {
            return node.next.next;
        } else {
            return null;
        }
    }

}
