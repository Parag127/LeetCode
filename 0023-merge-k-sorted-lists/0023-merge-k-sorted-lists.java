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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        ListNode dummyNode = new ListNode(-1);
        ListNode dummy = dummyNode;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }


        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            dummy.next = temp;

            if (temp != null && temp.next != null) {
                pq.offer(temp.next);
            }
            dummy = dummy.next;
        }

        return dummyNode.next;

    }
}