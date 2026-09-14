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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        ListNode newHead = null;
        if (fast == null) {
            newHead = prevSlow.next;
            prevSlow.next = null;
        } else {
            newHead = slow.next;
            slow.next = null;
        }

        ListNode curr = newHead;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        newHead = prev;

        while (newHead != null && head != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
}