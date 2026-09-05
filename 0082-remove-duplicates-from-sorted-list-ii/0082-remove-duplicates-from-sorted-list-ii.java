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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1);
        
        ListNode temp = dummyNode;
        temp.next = head;
        ListNode current = head;

        while (current != null) {

            if (current.next != null && current.val == current.next.val) {

                int duplicate = current.val;

                while (current != null && current.val == duplicate) {
                    current = current.next;
                }

                temp.next = current;
            } else {
                temp = current;
                current = current.next;
            }
        }
        return dummyNode.next;
    }
}