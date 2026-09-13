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
        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            if (temp == null) return head;
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode current = head;
        int i = 0;
        while (i < k) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        head.next = reverseKGroup(current, k);
        return prev;
    }
}