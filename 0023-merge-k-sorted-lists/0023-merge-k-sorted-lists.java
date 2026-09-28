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

        ListNode dummyNode = new ListNode(-1);
        ListNode dummy = dummyNode; 
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        } 

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();

            dummy.next = temp;
            dummy = temp;

            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }

        return dummyNode.next;
    }       
    
}