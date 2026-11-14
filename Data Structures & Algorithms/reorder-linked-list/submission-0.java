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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode firstHalf = head;
        secondHalf = reverse(secondHalf);
        while(secondHalf != null) {
            ListNode firstNext = firstHalf.next;
            ListNode secondNext = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = firstNext;
            firstHalf = firstNext;
            secondHalf = secondNext;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode reverse = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }
}
