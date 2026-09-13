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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        int k = 0;
        ListNode temp = head;
        while(temp != null) {
            k++;
            temp = temp.next;
        }
        k -= n;
        if (k == 0) return head.next;
        temp = head;
        while (head != null && k > 1) {
            k--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

}