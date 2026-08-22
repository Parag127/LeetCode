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
    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode (-1);
        ListNode temp = dummyNode;
        int sum = 0;

        while (head != null && head.next != null) {
            sum += head.val;

            if (head.val == 0) {
                sum = 0;
            } else if (head.next.val == 0) {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            
            head = head.next;
        }
        return dummyNode.next;
    }
}