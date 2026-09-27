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
        preOrder(root, k);
        return pq.peek();
    }

    void preOrder(TreeNode root, int k) {

        if (root == null) return;
        
        pq.add(root.val);
        if (pq.size() > k) pq.poll();
        preOrder(root.left, k);
        preOrder(root.right, k);
    } 
}