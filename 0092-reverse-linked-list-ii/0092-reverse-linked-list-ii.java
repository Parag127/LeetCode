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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;

        ListNode k = temp;
        int count = 1;
        while (count != right) {
            k = k.next;
            count++;
        }
        ListNode nextNode = k.next;
        k.next = null;

        ListNode prevNode = null;
        count = 1;
        while (count != left && temp != null) {
            if (count + 1 == left) prevNode = temp;
            temp = temp.next;
            count++;
        }

        ListNode newTemp = reverseLL(temp);

        if (prevNode == null) {
            head = newTemp;
        } else {
            prevNode.next = newTemp;
        }

        while (newTemp != null && newTemp.next != null) {
            newTemp = newTemp.next;
        }

        newTemp.next = nextNode;
        return head;
    }

    static ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode last = curr.next;
            curr.next = prev;
            prev = curr;
            curr = last;
        }

        return prev;

    }
}