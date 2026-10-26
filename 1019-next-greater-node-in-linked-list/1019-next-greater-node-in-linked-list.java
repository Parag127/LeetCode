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
    public int[] nextLargerNodes(ListNode head) {
        
        int size = len(head, 0);
        head = reverse(head);
        
        int[] nge = new int[size];
        return NGE(head, nge);

    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public int len (ListNode head, int count) {
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public int[] NGE(ListNode head, int[] NGE) {
        int n = NGE.length;

        Stack<Integer> st = new Stack<>();

        int i = n - 1;

        while (i >= 0) {

            while (!st.isEmpty() && head.val >= st.peek()) {
                st.pop();
            }

            NGE[i] = st.isEmpty() ? 0 : st.peek();

            st.push(head.val);
            head = head.next;
            i--;
        }

        return NGE;
    }
}