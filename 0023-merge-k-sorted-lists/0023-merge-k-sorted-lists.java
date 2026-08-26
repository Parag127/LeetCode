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
        return divide(lists, 0, lists.length - 1);
    }

    static ListNode divide(ListNode[] lists, int beg, int end){
        if (beg >= end) {
            return lists[beg];
        }
            int mid = (beg + end) / 2;
            ListNode left = divide(lists, beg, mid);
            ListNode right = divide(lists, mid + 1, end);
            return mergeLL(left, right);
    }

    static ListNode mergeLL(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null)
            temp.next = list1;
        if (list2 != null)
            temp.next = list2;

        return dummyNode.next;
    }
}