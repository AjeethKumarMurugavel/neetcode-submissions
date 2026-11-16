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
        ListNode dummy = head;
        ListNode top = head;
        int i=0;
        ListNode end = null;
        ListNode prevEnd = null;
        ListNode result = head;
        while(dummy != null) {
            i++;
            ListNode next = dummy.next;
            if(i == k) {
                dummy.next = null;
                end = top;
                top = reverse(top);
                if(prevEnd != null) {
                    prevEnd.next = top;
                } else {
                    result = top;
                }
                prevEnd = end;
                top = next;
                i = 0;
            }
            dummy = next;
        }
        if(i != 0) {
            prevEnd.next = top;
        }
        return result;
    }

    public ListNode reverse(ListNode node) {
        ListNode result = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node = next;
        }
        return result;
    }
}
