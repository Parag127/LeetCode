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

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
        ListNode dummyNode = new ListNode(-1);
        ListNode dummy = dummyNode;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.offer(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (temp.next != null) {
                pq.offer(temp.next);
            }

            dummy.next = temp;
            dummy = temp;
        }
        return dummyNode.next;
    }       
    
}