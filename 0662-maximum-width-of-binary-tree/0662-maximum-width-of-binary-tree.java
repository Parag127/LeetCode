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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair (root, 0));

        int ans = 0;

        while(!q.isEmpty()) {
            int min = q.peek().num;
            int first = 0;
            int last = 0;

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.peek().num - min;

                if (i == 0) first = curr;
                if (i == size - 1) last = curr;
                
                TreeNode temp = q.poll().node;

                if (temp.left != null) {
                    q.offer(new Pair(temp.left, curr * 2 + 1));
                }

                if (temp.right != null) {
                    q.offer(new Pair(temp.right, curr * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    class Pair {
        TreeNode node;
        int num;

        Pair (TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}