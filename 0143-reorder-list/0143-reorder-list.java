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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode first = head;
        ListNode second = reverseList(temp);

        while (first != null && second != null) {
            ListNode fNext = first.next;
            ListNode sNext = second.next;

            first.next = second;
            second.next = fNext;

            first = fNext;
            second = sNext;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode last = curr.next;
            curr.next = prev;
            prev = curr;
            curr = last;
        }
        return prev;
    }
}