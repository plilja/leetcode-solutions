/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        ListNode currentA = headA;
        ListNode currentB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; ++i) {
                currentA = currentA.next;
            }
        }
        if (sizeB > sizeA) {
            for (int i = 0; i < sizeB - sizeA; ++i) {
                currentB = currentB.next;
            }
        }
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
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