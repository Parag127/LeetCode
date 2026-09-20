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
        if(head == null) return head;

        int k = 0;
        ListNode temp = head;
        while (temp != null) {
            k++;
            temp = temp.next;
        }
        
        if (n == k) return head.next;

        k -= n;
        temp = head;
        while (k > 1) {
            temp = temp.next;
            k--;
        }

        temp.next = temp.next.next;
        return head;
    }
}