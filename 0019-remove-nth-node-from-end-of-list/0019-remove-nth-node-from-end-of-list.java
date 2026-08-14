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
    public static int LLL(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    } 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return head.next;
        int count = LLL(head);
        int pos = count - n + 1;
        
        if (pos == 1) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        int k = 0;
        ListNode prev = null;

        while (temp != null) {
            k++;
            if (k == pos) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}