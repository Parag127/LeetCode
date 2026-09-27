/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int kthSmallest(TreeNode root, int k) {           
        preOrder(root);

        int size = pq.size();
        for (int i = i = 0; i < size; i++) {
            if (pq.size() > k) pq.poll();
            else break;
        }

        return pq.peek();
    }

    void preOrder(TreeNode root) {

        if (root == null) return;
        
        pq.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    } 
}